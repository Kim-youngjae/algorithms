package com.baekjoon.p12852;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N + 1];
        int[] trace = new int[N + 1];

        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            trace[i] = i - 1;

            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                trace[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                trace[i] = i / 3;
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(dp[N] + "\n");
        while (N > 0) {
            sb.append(N + " ");
            N = trace[N];
        }

        System.out.println(sb);
        sc.close();
    }
}
