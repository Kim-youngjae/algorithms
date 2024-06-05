package com.baekjoon.p24445;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

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

        bfs(R);
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] result = new int[N + 1];
        boolean[] v = new boolean[N + 1];

        int cnt = 1;
        result[start] = cnt++;
        v[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph.get(now)) {
                if (!v[next]) {
                    result[next] = cnt++;
                    v[next] = true;
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(result[i] + "\n");
        }

        System.out.println(sb);
    }
}
