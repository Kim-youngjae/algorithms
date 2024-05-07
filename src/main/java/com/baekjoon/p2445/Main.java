package com.baekjoon.p2445;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for (int i = 1; i <= 2 * N - 1; i++) {
            if (i <= N) {
                for (int j = 0; j < i; j++) {
                    sb.append("*");
                }
                for (int j = 0; j < 2 * N - 2 * i; j++) {
                    sb.append(" ");
                }
                for (int j = 0; j < i; j++) {
                    sb.append("*");
                }
                sb.append("\n");
            } else {
                for (int j = 0; j < 2 * N - i; j++) {
                    sb.append("*");
                }
                for (int j = 0; j < 2 * i - 2 * N; j++) {
                    sb.append(" ");
                }
                for (int j = 0; j < 2 * N - i; j++) {
                    sb.append("*");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
        sc.close();
    }
}
