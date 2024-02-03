package com.baekjoon.p2573;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int n, m;

    static int[] dr = { 1, 0, -1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ice = 0; // 덩어리 갯수
        int year = 0; // 년 수

        while ((ice = countIce()) < 2) {
            if (ice == 0) {
                year = ice;
                break;
            }

            melt();
            year++;
        }

        System.out.println(year);
    }

    private static void melt() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    q.add(new int[] { i, j });
                    visit[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            int seaNum = 0;

            int cr = temp[0];
            int cc = temp[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 0 && !visit[nr][nc]) {
                    seaNum++;
                }
            }

            if (map[cr][cc] - seaNum < 0) {
                map[cr][cc] = 0;
            } else {
                map[cr][cc] -= seaNum;
            }
        }
    }

    // 빙하 개수 세기
    private static int countIce() {
        boolean[][] visit = new boolean[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visit[i][j]) {
                    dfs(i, j, visit);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void dfs(int r, int c, boolean[][] visit) {
        visit[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visit[nr][nc] && map[nr][nc] != 0) {
                dfs(nr, nc, visit);
            }
        }
    }

}