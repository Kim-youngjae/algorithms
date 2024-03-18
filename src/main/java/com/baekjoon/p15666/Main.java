package com.baekjoon.p15666;

import java.util.*;

public class Main {
    static int N, M;
    static int[] a;
    static int[] ans;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        a = new int[N];
        ans = new int[M];

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

        int before = 0;
        for (int i = from; i < N; i++) {
            if (before != a[i]) {
                ans[depth] = a[i];
                before = a[i];
                dfs(i, depth + 1);
            }
        }
    }
}
