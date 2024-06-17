package com.baekjoon.p14620;

import java.io.*;
import java.util.*;

public class Main {
    static int N, min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = { 1, 0, -1, 0 };
    static int[] dc = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        v = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);
    }

    static void dfs(int cnt, int total) {
        if (cnt == 3) {
            min = Math.min(min, total);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (canPlant(i, j)) {
                    setVisit(i, j, true);
                    int sum = getSum(i, j);

                    dfs(cnt + 1, total + sum);
                    setVisit(i, j, false);
                }
            }
        }
    }

    static int getSum(int r, int c) {
        int sum = map[r][c];

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            sum += map[nr][nc];
        }

        return sum;
    }

    static void setVisit(int r, int c, boolean set) {
        if (set) {
            v[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                v[nr][nc] = true;
            }
        } else {
            v[r][c] = false;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                v[nr][nc] = false;
            }
        }
    }

    static boolean canPlant(int r, int c) {
        if (v[r][c]) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (v[nr][nc]) {
                return false;
            }
        }

        return true;
    }

}
