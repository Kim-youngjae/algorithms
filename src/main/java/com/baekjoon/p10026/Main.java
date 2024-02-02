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

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    if (map[i][j] == 'R') {
                        bfs(i, j, 'R');
                        R++;
                    } else if (map[i][j] == 'G') {
                        bfs(i, j, 'G');
                        G++;
                    } else if (map[i][j] == 'B') {
                        bfs(i, j, 'B');
                        B++;
                    }
                }
            }
        }

        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    if (map[i][j] == 'R' || map[i][j] == 'G') {
                        bfs(i, j);
                        CB++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append((R + G + B) + "\n");
        sb.append((CB + B));
        System.out.println(sb);
    }

    // 색맹 계산
    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { r, c });
        visit[r][c] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int cr = temp[0];
            int cc = temp[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visit[nr][nc]) {
                    if (map[nr][nc] == 'R' || map[nr][nc] == 'G') {
                        q.add(new int[] { nr, nc });
                        visit[nr][nc] = true;
                    }
                }
            }
        }
    }

    // 정상 구분 계산
    private static void bfs(int r, int c, char val) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { r, c });
        visit[r][c] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int cr = temp[0];
            int cc = temp[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visit[nr][nc] && map[nr][nc] == val) {
                    q.add(new int[] { nr, nc });
                    visit[nr][nc] = true;
                }
            }
        }
    }
}
