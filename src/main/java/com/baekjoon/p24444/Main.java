package com.baekjoon.p24444;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] v;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(R);
        System.out.print(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        v = new boolean[N + 1];
        int cnt = 0;
        int[] ans = new int[N + 1];

        q.add(start);
        v[start] = true;
        ans[start] = ++cnt;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (!v[next]) {
                    v[next] = true;
                    ans[next] = ++cnt;
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }
    }
}
