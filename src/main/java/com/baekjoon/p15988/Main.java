package com.baekjoon.p15988;

import java.io.*;

public class Main {

    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        dp = new long[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            if (n > 3) {
                for (int i = 4; i <= n; i++) {
                    dp[i] = ((dp[i - 1] % 1_000_000_009 + dp[i - 2] % 1_000_000_009 + dp[i - 3] % 1_000_000_009)
                            % 1_000_000_009);
                }
            }
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}
