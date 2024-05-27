package com.baekjoon.p10844;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int mod = 1_000_000_000;
        long[][] dp = new long[N + 1][10];

        // 자릿수가 1인 경우의 수는 1
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) { // 자릿수가 2부터 탐색

            for (int j = 0; j < 10; j++) { // 해당 자릿수의 값이 0 ~ 9일 때 경우의 수를 계산

                if (j == 0) { // 자릿수가 0이라면 이전 자릿수는 0밖에 못 옴
                    dp[i][0] = dp[i - 1][1] % mod; // dp[i][0] = i 번째 자릿수 값이 0
                } else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }

            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[N][i];
        }

        System.out.println(ans % mod);
    }
}
