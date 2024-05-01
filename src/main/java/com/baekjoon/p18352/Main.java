package com.baekjoon.p18352;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(r).add(c);
        }

        dijkstra(X);

    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        int[] dist = new int[N + 1];
        boolean[] v = new boolean[N + 1];

        Arrays.fill(dist, 1000000);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if (v[nowVertex])
                continue;

            v[nowVertex] = true;

            for (int next : list.get(nowVertex)) {
                if (dist[next] > dist[nowVertex] + 1) {
                    dist[next] = dist[nowVertex] + 1;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i + "\n");
            }
        }

        System.out.println(sb.length() == 0 ? -1 : sb);
    }
}

class Node {
    int index;
    int cost;

    Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
}