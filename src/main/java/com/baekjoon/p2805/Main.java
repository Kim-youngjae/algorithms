package com.baekjoon.p2805;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt(); // 가져가려고 하는 나무 길이

        int[] tree = new int[N];

        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
        }

        Arrays.sort(tree);

        int start = 0;
        int end = tree[N - 1];

        while (start < end) {
            long sum = 0; // 자른 나무의 총합
            int mid = (start + end) / 2;

            for (int t : tree) {
                if (t - mid > 0) {
                    sum += (t - mid);
                }
            }

            if (sum < M) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start - 1);
        sc.close();
    }
}
