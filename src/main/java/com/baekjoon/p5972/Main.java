package com.baekjoon.p5972;

import java.io.*;
import java.util.*;

public class Main {
    static List<List<Node>> graph;
    static boolean[] v;
    static int[] d;
    static int N;
    static final int INF = 100000000;

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return cost - n.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        dijkstra();

    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        v = new boolean[N + 1];
        d = new int[N + 1];
        Arrays.fill(d, INF);
        d[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            int nowVertex = pq.poll().idx;

            if (v[nowVertex]) {
                continue;
            }

            v[nowVertex] = true;

            for (Node next : graph.get(nowVertex)) {
                if (!v[next.idx]) {
                    if (d[next.idx] > d[nowVertex] + next.cost) {
                        d[next.idx] = d[nowVertex] + next.cost;
                        pq.add(new Node(next.idx, d[next.idx]));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(d[N]);
        System.out.println(sb);
    }
}
