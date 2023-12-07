package com.baekjoon.p2512;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] region = new int[N];

        for (int i = 0; i < N; i++) {
            region[i] = sc.nextInt();
        }

        int nationalBudget = sc.nextInt();

        Arrays.sort(region);

        // 상한액 구하기
        int min = 1;
        int max = region[N - 1];
        int upperLimit = 0; // 상한액
        int maxTotal = 0; // 상한액으로 계산한 총합

        while (min <= max) {
            int sum = 0;
            int budget = (min + max) / 2;

            // 제일 큰 금액의 절반을 상한액으로 시작
            for (int i = 0; i < N; i++) {
                if (region[i] < budget) {
                    sum += region[i];
                } else {
                    sum += budget;
                }
            }

            if (sum > nationalBudget) {
                max = budget - 1;
            } else {
                min = budget + 1;
                upperLimit = budget;
                maxTotal = Math.max(maxTotal, sum);
            }
        }

        System.out.println(upperLimit);
        sc.close();
    }
}
