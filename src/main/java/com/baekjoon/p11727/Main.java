package com.baekjoon.p11727;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007; // 모드연산을 하고 배열에 넣어준다. stackoverflow 방지
        }

        System.out.println(dp[n]);

    }
}
