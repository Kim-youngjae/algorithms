package com.programmers.level2.p49994;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("ULURRDLLU"));
    }

    public int solution(String dirs) {
        int answer = 0;

        int[] dx = new int[] { 1, 0, -1, 0 };
        int[] dy = new int[] { 0, -1, 0, 1 };
        int[][][][] map = new int[11][11][11][11]; // a -> b, b -> a를 기록하기 위함

        map[5][5][5][5] = 1; // 최초 시작점
        int cx = 5;
        int cy = 5;

        int route = 0;

        for (int i = 0; i < dirs.length(); i++) {
            int nx = 0, ny = 0; // 다음 지점
            char dir = dirs.charAt(i);

            switch (dir) {
                case 'R':
                    nx = cx + dx[0];
                    ny = cy + dy[0];
                    break;
                case 'D':
                    nx = cx + dx[1];
                    ny = cy + dy[1];
                    break;
                case 'L':
                    nx = cx + dx[2];
                    ny = cy + dy[2];
                    break;
                case 'U':
                    nx = cx + dx[3];
                    ny = cy + dy[3];
                    break;
            }

            // 다음 지점이 범위를 벗어나는지 확인. 벗어나면 고려하지 않기
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) {
                continue;
            }

            // 처음 방문하는 지점인지 확인
            if (map[cx][cy][nx][ny] == 0 && map[nx][ny][cx][cy] == 0) {
                // 양방향 체크
                map[cx][cy][nx][ny]++;
                map[nx][ny][cx][cy]++;
                route++;
            }

            // 현재 지점을 다음 지점으로 갱신
            cx = nx;
            cy = ny;
        }

        answer = route;

        return answer;
    }
}
