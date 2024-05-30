package com.baekjoon.p24480;

import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] v;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        v = new boolean[N + 1];
        res = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        cnt = 0;
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(res[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        v[start] = true;
        res[start] = ++cnt;

        for (int next : graph.get(start)) {
            if (!v[next]) {
                dfs(next);
            }
        }
    }
}
