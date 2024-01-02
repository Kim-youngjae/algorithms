package com.baekjoon.p1932;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[T + 1][T + 1];
        int[][] arr = new int[T + 1][T + 1];

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= t; i++) {
                arr[i][t] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= T; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }

        int result = 0;

        for (int i = 1; i <= T; i++) {
            if (result < dp[T][i]) {
                result = dp[T][i];
            }
        }

        System.out.println(result);
    }
}
