package com.baekjoon.dynamic_programming.p1010;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(combi(r, n) + "\n");
        }

        System.out.println(sb);
    }

    static int combi(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}
