package com.baekjoon.p1495;

import java.io.*;
import java.util.*;

public class Main {
    static int N, S, M;
    static boolean[][] dp;
    static int[] V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new boolean[N][M + 1];
        V = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        if (S - V[0] >= 0) {
            dp[0][S - V[0]] = true;
        }

        if (S + V[0] <= M) {
            dp[0][S + V[0]] = true;
        }

        for (int i = 0; i < N - 1; i++) {

            for (int j = 0; j <= M; j++) {
                if (dp[i][j]) {
                    adjust(i + 1, j);
                }
            }
        }

        int max = -1;

        for (int i = 0; i <= M; i++) {
            if (dp[N - 1][i]) {
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
    }

    static void adjust(int next, int vol) {
        if (vol - V[next] >= 0) {
            dp[next][vol - V[next]] = true;
        }

        if (vol + V[next] <= M) {
            dp[next][vol + V[next]] = true;
        }
    }
}
