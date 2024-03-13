package com.baekjoon.p15657;

import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        ans = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        dfs(0, 0);

        System.out.println(sb);
        sc.close();
    }

    static void dfs(int now, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = now; i < N; i++) {
            ans[depth] = arr[i];
            dfs(i, depth + 1);
        }
    }
}
