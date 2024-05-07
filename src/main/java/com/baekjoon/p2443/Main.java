package com.baekjoon.p2443;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }

            for (int j = 0; j < 2 * N - (2 * i + 1); j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.print(sb);
        sc.close();
    }
}
