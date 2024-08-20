package com.baekjoon.math.p11653;

import java.util.*;

public class Main {
    static int MAX_NUM = 10_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                N = N / i;
                sb.append(i + "\n");
            }
        }

        if (N != 1) {
            sb.append(N);
        }

        System.out.println(sb);
        sc.close();
    }
}
