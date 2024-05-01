package com.baekjoon.p18352;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static int[] dist;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            dist[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(r).add(c);
        }

        bfs(X);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i + "\n");
            }
        }

        System.out.println(sb.length() == 0 ? -1 : sb);
    }

    static void bfs(int start) {

        Queue<Integer> q = new ArrayDeque<>();

        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : list.get(now)) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}
