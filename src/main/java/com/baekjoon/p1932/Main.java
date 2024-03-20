package com.baekjoon.p1932;

import java.util.*;

public class Main {
    static int[][] seq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        seq = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                seq[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < N; i++) { // 행
            for (int j = 0; j <= i; j++) { // 열
                if (j == 0) {
                    seq[i][j] += seq[i - 1][j];
                } else if (j == i) {
                    seq[i][j] += seq[i - 1][j - 1];
                } else {
                    seq[i][j] += Math.max(seq[i - 1][j], seq[i - 1][j - 1]);
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            result = Math.max(result, seq[N - 1][i]);
        }

        System.out.println(result);
        sc.close();
    }
}
