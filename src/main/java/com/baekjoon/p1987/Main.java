package com.baekjoon.p1987;

import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static boolean[] v = new boolean[26];
    static int[][] map;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };
    static int ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0);

        System.out.println(ans);
    }

    static void dfs(int cnt, int r, int c) {
        if (v[map[r][c]]) {
            ans = Math.max(ans, cnt);
            return;
        } else {
            v[map[r][c]] = true;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    dfs(cnt + 1, nr, nc);
                }
            }

            v[map[r][c]] = false;
        }
    }
}
