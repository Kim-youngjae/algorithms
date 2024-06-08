package com.baekjoon.p1535;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = 99; // 세준이의 최대 체력

        int[] w = new int[N + 1], v = new int[N + 1];
        int[][] dp = new int[N + 1][K + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (w[i] <= j) { // 최대 체력에서 허용할 수 있는 범위 == 감사인사를 할 수 있음
                    /**
                     * 인사를 했을 떄와 안했을 때 얻는 기쁨을 비교하고 더 큰 값으로 갱신
                     */
                    dp[i][j] = Math.max(dp[i - 1][j - w[i]] + v[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][K]);

    }

}
