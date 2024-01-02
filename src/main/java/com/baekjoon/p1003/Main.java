package com.baekjoon.p1003;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();

            int[][] dp = new int[41][2];
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;

            for (int i = 2; i <= N; i++) {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
            }

            sb.append(dp[N][0] + " " + dp[N][1]).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }

}
