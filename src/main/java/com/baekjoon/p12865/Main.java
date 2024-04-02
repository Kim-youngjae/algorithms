package com.baekjoon.p12865;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K, W, V;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            dp[W] = V;
        }

        for (int n = 3; n <= K; n++) {
            int max = dp[n];

            for (int i = 1; i <= (n / 2); i++) {
                dp[n] = Math.max(max, dp[i] + dp[n - i]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= K; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
