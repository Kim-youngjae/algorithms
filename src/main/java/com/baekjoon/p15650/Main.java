package com.baekjoon.p15650;

import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        select(1, 0);

        System.out.println(sb);
        sc.close();
    }

    private static void select(int at, int depth) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= n; i++) {
            arr[depth] = i;
            select(i + 1, depth + 1);
        }
    }
}
