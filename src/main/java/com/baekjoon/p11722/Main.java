package com.baekjoon.p11722;

import java.util.*;

public class Main {
    static int N;
    static int[] a, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        a = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
            dp[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] < a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        sc.close();
    }

}
