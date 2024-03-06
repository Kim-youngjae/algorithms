package com.baekjoon.p15652;

import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] v;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        dfs(1, 0);

        System.out.println(sb);
        sc.close();
    }

    static void dfs(int num, int depth) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = num; i <= N; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
