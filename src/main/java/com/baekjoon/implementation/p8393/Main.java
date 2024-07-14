package com.baekjoon.implementation.p8393;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            sum += i;
        }

        System.out.println(sum);
        sc.close();
    }
}
