package com.baekjoon.p10819;

import java.io.*;
import java.util.*;

public class Main {
    static int N, max;
    static int[] a, ans;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        a = new int[N];
        ans = new int[N];
        v = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
    }

    static void dfs(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(ans[i] - ans[i + 1]);
            }

            max = Math.max(max, sum);
        }

        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                ans[depth] = a[i];
                dfs(depth + 1);
                v[i] = false;
            }
        }

    }
}