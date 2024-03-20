package com.baekjoon.p1932;

import java.util.*;

public class Main {
    static int[][] dp;
    static int[][] seq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new int[N + 1][N + 1];
        seq = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                seq[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= N; i++) { // 행
            for (int j = 1; j <= i; j++) { // 열
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + seq[i][j];
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dp[N][i]);
        }

        System.out.println(result);
        sc.close();
    }
}
