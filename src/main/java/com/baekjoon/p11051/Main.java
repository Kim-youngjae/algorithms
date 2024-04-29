package com.baekjoon.p11051;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new int[1001][1001];

        dp[1][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i <= 1000; i++) {
            for (int j = 0; j < (i + 1); j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (j >= 1 && j < i) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
                } else { // j == i
                    dp[i][j] = 1;
                }
            }
        }

        String[] list = br.readLine().split(" ");

        int N = Integer.parseInt(list[0]);
        int K = Integer.parseInt(list[1]);

        System.out.println(dp[N][K]);
    }
}
