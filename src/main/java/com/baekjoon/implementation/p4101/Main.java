package com.baekjoon.implementation.p4101;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a == 0 && b == 0) {
                break;
            }

            if (a > b) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }

        System.out.println(sb);
        sc.close();
    }
}
