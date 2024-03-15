package com.baekjoon.p11053;

import java.util.*;

// Bottom-up 방식
public class Main {

    static int[] seq;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        seq = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && dp[i] < dp[j] + 1) { // 현재 ㄱ밧이
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            if (max < i) {
                max = i;
            }
        }

        System.out.println(max);
        sc.close();
    }
}

// Top-down 방식(재귀) 풀이
// public class Main {

// static int[] seq;
// static int[] dp;

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);

// int N = sc.nextInt();

// seq = new int[N];
// dp = new int[N];

// for (int i = 0; i < N; i++) {
// seq[i] = sc.nextInt();
// }

// for (int i = 0; i < N; i++) {
// LIS(i);
// }

// int max = Integer.MIN_VALUE;
// for (int i : dp) {
// if (max < i) {
// max = i;
// }
// }

// System.out.println(max);
// sc.close();
// }

// static int LIS(int idx) {

// if (dp[idx] == 0) { // 방문하지 않았으면..?
// dp[idx] = 1; // 부분 수열을 1로 초기화

// for (int i = idx - 1; i >= 0; i--) { // 해당 인덱스 이전의 모든 인덱스를 탐색
// if (seq[i] < seq[idx]) { // 지금 값보다 이전 인덱스의 값이 더 작으면
// dp[idx] = Math.max(dp[idx], LIS(i) + 1); // 부분 수열을 하나 추가하고 다른 부분 수열이 있는지 탐색
// }
// }
// }

// return dp[idx];
// }
// }