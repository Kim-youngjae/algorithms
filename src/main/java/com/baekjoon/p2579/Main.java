package com.baekjoon.p2579;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[T + 1];
        int[] dp = new int[T + 1];

        for (int t = 1; t <= T; t++) {
            arr[t] = Integer.parseInt(br.readLine());
        }

        if (T <= 2) {
            int sum = 0;
            for (int i = 0; i <= T; i++) {
                sum += arr[i];
                dp[i] += sum;
            }
        } else {
            dp[1] = arr[1]; // 1
            dp[2] = arr[1] + arr[2]; // 2
            dp[3] = Math.max(arr[1], arr[2]) + arr[3]; // 3

            for (int n = 3; n <= T; n++) {
                dp[n] = Math.max(dp[n - 2], dp[n - 3] + arr[n - 1]) + arr[n];
            }
        }

        System.out.println(dp[T]);
    }
}
