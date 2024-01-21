package com.swea.D3.p1217;

import java.util.*;

public class Solution {
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int tc = sc.nextInt();

            sb.append("#" + tc + " ");

            N = sc.nextInt();
            M = sc.nextInt();

            sb.append(power(N, 1) + "\n");
        }

        System.out.println(sb);
        sc.close();
    }

    private static int power(int n, int m) {
        if (m == M) {
            return n;
        }

        return power(n * N, m + 1);
    }
}
