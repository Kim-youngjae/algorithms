package com.baekjoon.p1743;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, max, cnt; // 세로길이, 가로길이, 음식물 개수
    static int[][] map;
    static boolean[][] v;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        v = new boolean[N + 1][M + 1];
        max = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!v[i][j] && map[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    max = Math.max(max, cnt);
                }
            }
        }

        System.out.println(max);

    }

    static void dfs(int r, int c) {
        v[r][c] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr <= N && nc >= 0 && nc <= M && !v[nr][nc] && map[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }
}
