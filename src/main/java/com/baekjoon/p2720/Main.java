package com.baekjoon.p2720;

import java.io.*;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.valueOf(br.readLine());
        int[] changes = new int[N];
        int[] coins = new int[] {25, 10, 5, 1};
        int coin = 0;


        for (int i = 0; i < N; i++) {
            changes[i] = Integer.valueOf(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            coin = changes[i];
            for (int j = 0; j < coins.length; j++) {
                sb.append(coin / coins[j] + " "); // 줘야할 동전 개수
                coin = coin % coins[j];
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
