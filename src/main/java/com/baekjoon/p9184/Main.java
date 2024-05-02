package com.baekjoon.p9184;

import java.io.*;
import java.util.*;

public class Main {
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        dp = new int[21][21][21];

        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    if (i <= 0 || j <= 0 || k <= 0) {
                        dp[i][j][k] = 1;
                    } else {
                        if (i < j && j < k) {
                            dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                        } else {
                            dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1]
                                    - dp[i - 1][j - 1][k - 1];
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append("w(").append(a + ", ").append(b + ", ").append(c + ") = ")
                    .append(w(a, b, c) + "\n");

        }

        System.out.println(sb);
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20];
        }
        if (a < b && b < c) {
            return dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c];
        }
        return dp[a - 1][b][c] + dp[a - 1][b - 1][c] + dp[a - 1][b][c - 1] - dp[a - 1][b - 1][c - 1];
    }
}
