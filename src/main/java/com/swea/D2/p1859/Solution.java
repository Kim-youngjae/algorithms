package com.swea.D2.p1859;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[] future = new int[N];

            for (int i = 0; i < N; i++) {
                future[i] = sc.nextInt();
            }

            int highPrice = future[N - 1];
            long profit = 0;

            for (int i = N - 2; i >= 0; i--) {
                if (highPrice < future[i]) {
                    highPrice = future[i];
                } else {
                    profit += (highPrice - future[i]);
                }
            }

            sb.append("#").append(t).append(" ").append(profit).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
