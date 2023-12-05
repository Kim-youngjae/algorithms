package com.baekjoon.p1970;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
        int[] result = new int[8];

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            for (int i = 0; i < money.length; i++) {
                result[i] = N / money[i];
                N %= money[i];
            }

            sb.append("#").append(t).append("\n");
            for (int r : result) {
                sb.append(r).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
