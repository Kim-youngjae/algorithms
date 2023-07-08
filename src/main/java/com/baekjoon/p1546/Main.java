package com.baekjoon.p1546;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        long sum = 0;
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        for (int i = 0; i < N; i++) {
            sum += scores[i] / max * 100;
        }

        System.out.println(sum / N);
    }
}
