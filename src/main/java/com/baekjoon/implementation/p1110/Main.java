package com.baekjoon.implementation.p1110;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int target = n;
        int cnt = 0;

        while (true) {
            n = ((n % 10) * 10) + (((n / 10) + (n % 10)) % 10);

            cnt++;

            if (target == n) {
                break;
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}
