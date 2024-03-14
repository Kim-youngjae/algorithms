package com.baekjoon.p11725;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parent;
    static List<Integer>[] list;
    static boolean[] v;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        parent = new int[N];
        list = new ArrayList[N];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            list[a].add(b);
            list[b].add(a);
        }

        dfs(0);

        for (int i = 1; i < N; i++) {
            sb.append(parent[i] + 1 + "\n");
        }

        System.out.println(sb);

    }

    static void dfs(int idx) {
        v[idx] = true;

        for (int i : list[idx]) {
            if (!v[i]) {
                parent[i] = idx;
                dfs(i);
            }
        }
    }
}
