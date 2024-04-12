package com.baekjoon.p11399;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        int sum = 0;
        int time = 0;
        for (int i = 0; i < N; i++) {
            time += a[i];
            sum += time;
        }

        System.out.println(sum);
        sc.close();
    }
}
