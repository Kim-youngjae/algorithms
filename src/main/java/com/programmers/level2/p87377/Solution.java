package com.programmers.level2.p87377;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.fill;

class Solution {

    public static void main(String[] args) {
        new Solution().solution(new int[][]{new int[]{0, 1, -1}, new int[]{1, 0, -1}, new int[]{1, 0, 1}});
    }
    public String[] solution(int[][] line) {
        String[] answer = {};

        Set<Point> points = intersections(line);
        char[][] matrix = pointToMatrix(points);

        /**
         * 2차원 char배열을 String 배열에 옮기는 부분이 잘 안된다..
         * 스트림이 이해가 안가서 혼자 구현을 해보려고 했는데 for문으로 구현하는 부분이 잘 안된다.
         */
        answer = drawOnCoordinate(matrix);

        return answer;
    }

    public static Point intersection(int[] line1, int[] line2) {
        // Ax + By + E = 0
        long A = line1[0];
        long B = line1[1];
        long E = line1[2];

        // Cx + Dy + F = 0
        long C = line2[0];
        long D = line2[1];
        long F = line2[2];

        long divisor = A * D - B * C;

        if (divisor == 0) {
            return null;
        }

        double x = (double) (B * F - E * D) / divisor;
        double y = (double) (E * C - A * F) / divisor;

        if (x != (long) x) return null;
        if (y != (long) y) return null;

        return Point.of((long) x, (long) y);
    }


    public Set<Point> intersections(int[][] lines) {
        Set<Point> points = new HashSet<>();

        for (int i = 0; i < lines.length; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                int[] line1 = lines[i];
                int[] line2 = lines[j];

                Point point = intersection(line1, line2);

                if (point != null) {
                    points.add(point);
                }
            }
        }

        return points;
    }

    public static Point getMinPoint(Set<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point point : points) {
            x = Math.min(x, point.x);
            y = Math.min(y, point.y);
        }
        return Point.of(x, y);
    }

    public static Point getMaxPoint(Set<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point point : points) {
            x = Math.max(x, point.x);
            y = Math.max(y, point.y);
        }
        return Point.of(x, y);
    }

    public static char[][] emptyMatrix(Set<Point> points) {
        Point maxPoint = getMaxPoint(points);
        Point minPoint = getMinPoint(points);

        int width = (int) (maxPoint.x - minPoint.x) + 1; // 길이보다 점은 하나 더 많음
        int height = (int) (maxPoint.y - minPoint.y) + 1;

        char[][] matrix = new char[height][width];

//        Arrays.stream(matrix).forEach(row -> Arrays.fill(row, '.'));

        for (int i = 0; i < height; i++) {
            Arrays.fill(matrix[i], '.');
        }

        return matrix;
    }

    // 0, 0를 기준으로 그려지는 교점의 위치
    public static Set<Point> getPositiveIntersections(Set<Point> points) {
        Point minPoint = getMinPoint(points);
        Set<Point> posPoints = new HashSet<>();

        for (Point point : points) {
            posPoints.add(Point.of((point.x - minPoint.x), (point.y - minPoint.y)));
        }

        return posPoints;
    }

    public static char[][] pointToMatrix(Set<Point> points) {
        char[][] matrix1 = emptyMatrix(points);
        Set<Point> posPoints = getPositiveIntersections(points);

        for (Point point : posPoints) {
            matrix1[(int) point.y][(int) point.x] = '*';
        }

        return matrix1;

        // 배열 뒤집기
//        char[][] matrix2 = new char[matrix1.length][matrix1[0].length];
//
//        for (int i = matrix1.length - 1; i >= 0; i--) {
//            for (int j = 0; j < matrix1[0].length; j++) {
//                matrix2[matrix1.length - 1 - i][j] = matrix1[i][j];
//            }
//        }
//        return matrix2;
    }

    public String[] drawOnCoordinate(char[][] matrix) {
        return Ut.revRange(0, matrix.length)
                .boxed()
                .map(i -> matrix[i])
                .map(row -> new String(row))
                .toArray(String[]::new);
    }
}

class Ut {
    static IntStream revRange(int from, int to) {
        return IntStream.range(from, to)
                .map(i -> to - i + from - 1);
    }
}

// 일급 컬렉션
class Points {
    private final Set<Point> data;

    private Points(Set<Point> data) {
        this.data = data;
    }

    // Point... 는 Point[] 와 같은 뜻
    // Point... 의 특수기능 : 가변인자
    // Points.of(arg1);
    // Points.of(arg1, arg2);
    // Points.of(arg1, arg2, agr3);
    public static Points of(Point... pointArray) {
        // 입력받은 배열을 HashSet 형태로 하다.
        // Collectors.toSet()(-> immutable set으로 생성됨) 를 사용하지 않는 이유 : 우리는 mutable 한것을 원한다.
        // mutable : 수정가능
        // immutable : 수정불가능(add, remove 등이 안됨)
        return new Points(
                Arrays.stream(pointArray)
                        .collect(Collectors.toCollection(HashSet::new))
        );
    }
}


class Point {
    long x;
    long y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(long x, long y) {
        return new Point(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}