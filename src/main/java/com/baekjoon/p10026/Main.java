package com.baekjoon.p10026;

import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visit;
    static int n;
    static int R = 0;
    static int G = 0;
    static int B = 0;
    static int CB = 0;

    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                    result++;
                }
            }
        }

        sb.append(result + "\n");

        result = 0;
        visit = new boolean[n][n];

        // R과 B를 똑같이 맞춰줌
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }

        // 색맹 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                    result++;
                }
            }
        }

        sb.append(result);

        System.out.println(sb);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        char target = map[r][c];

        q.add(new int[] { r, c });
        visit[r][c] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int cr = temp[0];
            int cc = temp[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visit[nr][nc] && map[nr][nc] == target) {
                    q.add(new int[] { nr, nc });
                    visit[nr][nc] = true;
                }
            }
        }
    }
}
