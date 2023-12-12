package com.baekjoon.p2467;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        long min = Long.MAX_VALUE;
        long l1 = 0;
        long l2 = 0;

        for (int i = 0; i < N; i++) {

            int left = i + 1;
            int right = N - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                long sum = arr[i] + arr[mid];

                if (min >= Math.abs(sum)) {
                    min = Math.abs(sum);
                    l1 = arr[i];
                    l2 = arr[mid];
                }

                if (sum >= 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        System.out.println(l1 + " " + l2);

        // while (left < right) {
        // long sum = arr[left] + arr[right];
        // if (min >= Math.abs(sum)) {
        // min = Math.abs(sum);
        // l1 = arr[left];
        // l2 = arr[right];
        // }

        // if (sum >= 0) {
        // right--;
        // } else {
        // left++;
        // }
        // }
        sc.close();
    }
}
