package com.baekjoon.implementation.p2480;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a != b && b != c && a != c) {
            int max;

            if (a > b) {
                if (a > c) {
                    max = a;
                } else {
                    max = c;
                }
            } else {
                if (b > c) {
                    max = b;
                } else {
                    max = c;
                }
            }

            System.out.println(max * 100);
        } else {
            if (a == b && a == c) {
                // 모두 같은 수일 경우
                System.out.println(10000 + a * 1000);
            } else {
                if (a == b || a == c) {
                    System.out.println(1000 + a * 100);
                } else {
                    System.out.println(1000 + b * 100);
                }
            }
        }

        sc.close();
    }
}
