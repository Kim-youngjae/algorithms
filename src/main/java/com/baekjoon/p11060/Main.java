package com.baekjoon.p11060;

import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];
        int[] arr = new int[N + 1];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        dp[1] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= arr[i]; j++) {
                if (i + j <= N)
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        if (dp[N] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}