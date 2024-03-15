package com.baekjoon.p15663;

import java.util.*;

public class Main {
    static int N, M;
    static Set<String> ans = new LinkedHashSet<>();
    static int[] a, result;
    static boolean[] v;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        a = new int[N];
        result = new int[M];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        dfs(0);

        System.out.println(sb);
        sc.close();
    }

    static void dfs(int depth) {

        if (depth == M) {
            // StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;

        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                if (before != a[i]) {
                    v[i] = true;
                    result[depth] = a[i];
                    before = a[i];
                    dfs(depth + 1);
                    v[i] = false;
                }
            }
        }
    }
}
