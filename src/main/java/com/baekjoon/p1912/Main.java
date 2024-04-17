package com.baekjoon.p1912;

import java.io.*;
import java.util.*;

public class Main {
    static int[] a, dp;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N];
        a = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        a[0] = dp[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(a[i], dp[i - 1] + a[i]);
        }

        for (int i = 0; i < N; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.println(max);

    }
}
