package com.baekjoon.p9251;

import java.util.*;

public class Main {
    static int N, M;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        N = s1.length();
        M = s2.length();

        char[] c1 = new char[N + 1];
        char[] c2 = new char[M + 1];
        c1[0] = '0';
        c2[0] = '0';

        for (int i = 1; i <= N; i++) {
            c1[i] = s1.charAt(i - 1);
        }
        for (int i = 1; i <= M; i++) {
            c2[i] = s2.charAt(i - 1);
        }

        dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (c2[i] == c1[j]) { // 같은 경우
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[M][N]);
        sc.close();
    }
}
