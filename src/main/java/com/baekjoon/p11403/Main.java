package com.baekjoon.p11403;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] v;
    static int[][] map, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = ans = new int[N][N];
        v = new boolean[N];
        StringTokenizer st;

        // 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    v = new boolean[N];
                    dfs(i, j);
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        // sb.append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int r, int c) {
        ans[r][c] = 1;
        v[c] = true;

        for (int i = 0; i < N; i++) {
            if (!v[i] && map[c][i] == 1) {
                ans[r][i] = 1;
                dfs(r, i);
            }
        }
    }
}
