package com.baekjoon.p15990;

import java.io.*;
import java.util.*;

public class Main {
    static final int num = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] dp = new int[num][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < num; i++) {
            dp[i][1] = ((dp[i - 1][2] % 1_000_000_009) + (dp[i - 1][3] % 1_000_000_009)) % 1_000_000_009;
            dp[i][2] = ((dp[i - 2][1] % 1_000_000_009) + (dp[i - 2][3] % 1_000_000_009)) % 1_000_000_009;
            dp[i][3] = ((dp[i - 3][1] % 1_000_000_009) + (dp[i - 3][2] % 1_000_000_009)) % 1_000_000_009;
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int ans = dp[N][1] + dp[N][2] + dp[N][3];

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
