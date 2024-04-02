package com.baekjoon.p12865;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] dp;
    static int[] W;
    static int[] V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];
        W = new int[N + 1];
        V = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {

                /*
                 * 넣으려고 하는 물건의 무게가 총 무게보다 많이 나가면
                 * 이전 물건을 수용할 수 있는 최대 무게에 대한 가치의 합이 최대 가치의 합
                 */
                if (W[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /*
                     * 비교하려는 무게가 최대 무게보다 가벼워서 가방에 넣을 수 있는 경우
                     * (수용하려는 무게 - 넣으려는 물건의 무게에 대한 가치 + 넣으려는 무게의 가치) vs (이전까지 넣은 무게에 대한 가치) 중 더 큰 값이
                     * 최대 가치의 합
                     */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }

        System.out.println(dp[N][K]);

    }
}
