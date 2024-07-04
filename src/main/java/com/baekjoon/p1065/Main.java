package com.baekjoon.p1065;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int cnt = 0;

        if (N < 100) {
            cnt = N;
        } else {
            cnt = 99;

            for (int i = 100; i <= N; i++) {
                int hundred = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if (hundred - ten == ten - one) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        sc.close();
    }
}
