package com.baekjoon.p11048;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max;
    static int[][] a;
    static int[] dr = { 1, 0, 1 };
    static int[] dc = { 0, 1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N][M];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dfs(0, 0, 0);
        // System.out.println(max + a[0][0]);
        // bfs();
        dp();
    }

    static void dfs(int r, int c, int sum) {
        if (r == N - 1 && c == M - 1) {
            max = Math.max(max, sum);
            return;
        }

        if (c + 1 < M) {
            dfs(r, c + 1, sum + a[r][c + 1]);
        }
        if (r + 1 < N) {
            dfs(r + 1, c, sum + a[r + 1][c]);
        }
        if (r + 1 < N && c + 1 < M) {
            dfs(r + 1, c + 1, sum + a[r + 1][c + 1]);
        }
    }

    static void bfs() {
        int[][] map = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[] { 0, 0 });
        map[0][0] = a[0][0];

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 3; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr < N && nc < M) {
                    if (map[nr][nc] < map[now[0]][now[1]] + a[nr][nc]) {
                        map[nr][nc] = map[now[0]][now[1]] + a[nr][nc];
                        q.add(new int[] { nr, nc });
                    }
                }
            }
        }

        System.out.println(map[N - 1][M - 1]);
    }

    static void dp() {
        int[][] dp = new int[N][M];

        dp[0][0] = a[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 1 < N) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], a[i + 1][j] + dp[i][j]);
                }
                if (j + 1 < M) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], a[i][j + 1] + dp[i][j]);
                }
                if (i + 1 < N && j + 1 < M) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], a[i + 1][j + 1] + dp[i][j]);
                }
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }

}
