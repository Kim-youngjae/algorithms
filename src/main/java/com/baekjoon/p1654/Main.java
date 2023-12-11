package com.baekjoon.p1654;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] cables = new int[K];
        int maxLen = 0;

        for (int i = 0; i < K; i++) {
            cables[i] = sc.nextInt();
            maxLen = Math.max(maxLen, cables[i]);
        }

        long start = 1;
        long end = maxLen;

        while (start <= end) {
            long cnt = 0;
            long mid = (start + end) / 2;

            for (int c : cables) {
                cnt += (c / mid);
            }

            if (cnt >= N) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);

        sc.close();
    }
}
