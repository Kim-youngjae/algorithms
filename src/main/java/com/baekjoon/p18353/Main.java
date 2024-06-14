package com.baekjoon.p18353;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int max = 1;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < N; j++) {
                if (seq[j] > seq[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(dp[i], max);
                }
            }
        }

        System.out.println(N - max);
    }
}
