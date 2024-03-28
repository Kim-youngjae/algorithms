package com.baekjoon.p15655;

import java.util.*;

public class Main {

    static int N, M;
    static int[] a;
    static int[] ans;
    static boolean[] v;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        a = new int[N];
        ans = new int[M];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        dfs(0, 0);

        System.out.println(sb);
        sc.close();
    }

    static void dfs(int from, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = from; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                ans[depth] = a[i];
                dfs(i, depth + 1);
                v[i] = false;
            }
        }

    }
}
