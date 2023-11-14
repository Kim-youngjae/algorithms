package com.baekjoon.p7569;

import java.io.*;
import java.util.*;

public class Main {
    static int[][][] map;
    static int m, n, h;
    static Queue<Tomato> q1 = new LinkedList<>(); // 1위치를 저장

    static int[] dirRow = { -1, 0, 1, 0, 0, 0 };
    static int[] dirCol = { 0, 1, 0, -1, 0, 0 };
    static int[] dirHeight = { 0, 0, 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.valueOf(st.nextToken());
        n = Integer.valueOf(st.nextToken());
        h = Integer.valueOf(st.nextToken());

        map = new int[h][n][m];

        // 배열 초기화
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.valueOf(st.nextToken());
                    if (map[i][j][k] == 1) {
                        q1.add(new Tomato(i, j, k)); // 익은 토마토 위치 정보
                    }
                }
            }
        }

        int result = bfs(q1, 0); // 익은 토마토 정보와 날짜를 계산할 변수

        System.out.println(result);
    }

    private static int bfs(Queue<Tomato> q, int day) {

        while (!q.isEmpty()) {
            // 큐에서 토마토 위치 정보를 확인
            Tomato tomato = q.remove();

            int currR = tomato.getX();
            int currC = tomato.getY();
            int currH = tomato.getZ();

            for (int i = 0; i < 6; i++) {
                int nr = currR + dirRow[i];
                int nc = currC + dirCol[i];
                int nh = currH + dirHeight[i];

                if (check(nr, nc, nh)) {
                    q1.add(new Tomato(nr, nc, nh));
                    map[nh][nr][nc] = map[currH][currR][currC] + 1;
                }
            }
        }
        // 최대 값을 구하기 위한 변수
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    // 하나라도 익지 않은 토마토가 있다면 -1을 반환
                    if (map[i][j][k] == 0)
                        return -1;
                    // 토마토가 익는데 걸리는 시간을 구함
                    result = Math.max(result, map[i][j][k]);
                }
            }
        }
        // 최대 값이 1이라면 원래부터 모두 익어있었다는 것
        if (result == 1)
            return 0;
        // (최대 값 - 1) --> 걸린 일수
        else
            return (result - 1);
    }

    private static boolean check(int nr, int nc, int nh) {
        if (nr >= 0 && nr < n && nc >= 0 && nc < m && nh >= 0 && nh < h) {
            if (map[nh][nr][nc] == 0)
                return true; // 안익은 토마토 위치
            else
                return false; // 이미 익었거나 비어있으면
        }
        return false;

    }
}

class Tomato {
    private int x, y, z;

    public Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
