package com.baekjoon.p1965;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int maxBox = 0;
        for (int i = 0; i < N; i++) {
            // 자신보다 작은 값이 없으면 1이기 때문에 초기화 해주기
            dp[i] = 1;

            // 자신보다 작은 값들중 가장 큰 값을 고르기
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            // 최대값 갱신해주기
            maxBox = Math.max(maxBox, dp[i]);
        }

        System.out.println(maxBox);
    }
}
