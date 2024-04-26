package com.baekjoon.p1699;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[100001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= N; i++) {
            int min = Integer.MAX_VALUE;

            if (Math.floor(Math.sqrt(i)) == Math.sqrt(i)) {
                dp[i] = 1;
                continue;
            }

            for (int j = 1; j <= i / 2; j++) {
                min = Math.min(min, dp[i - j] + dp[j]);
            }

            dp[i] = min;
        }

        System.out.println(dp[N]);
        sc.close();
    }
}
