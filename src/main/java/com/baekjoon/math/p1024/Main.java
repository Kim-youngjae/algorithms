package com.baekjoon.math.p1024;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int L = sc.nextInt();

        /**
         * N이 주어졌을 때 자연수(L)로 나누게 되면 그 몫(N/L)의 앞뒤 수를 (L-1)/2 만큼 더하거나 뺏을 때 연속된 수가 나온다.
         * 연속된 수의 가장 처음 수 -> N / L - (L - 1) / 2
         */
        while (true) {
            int min = N / L - (L - 1) / 2;

            if (min < 0 || L > 100) {
                sb.append(-1);
                break;
            }

            int sum = L * (min * 2 + (L - 1)) / 2;

            if (sum == N) {
                for (int i = 0; i < L; i++) {
                    sb.append((min + i) + " ");
                }
                break;
            }

            L++;
        }

        System.out.println(sb);
        sc.close();
    }
}
