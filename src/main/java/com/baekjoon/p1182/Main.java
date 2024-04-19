package com.baekjoon.p1182;

import java.io.*;
import java.util.*;

public class Main {

    static int N, S, cnt;
    static int[] a;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        a = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(S == 0 ? cnt - 1 : cnt);

    }

    static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                cnt++;
            }
            return;
        }

        dfs(depth + 1, sum + a[depth]);
        dfs(depth + 1, sum);
    }
}
