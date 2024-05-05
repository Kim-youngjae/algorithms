package com.baekjoon.p1753;

import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static List<List<Node>> graph;
    static boolean[] v;
    static int[] d;
    static final int INF = 100000000;

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        Node(int index, int cost) {
            this.index = index;
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
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine()); // 시작 정점

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        dijkstra(start);
    }

    static void dijkstra(int start) {
        v = new boolean[V + 1];
        d = new int[V + 1];
        Arrays.fill(d, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if (v[nowVertex]) {
                continue;
            }

            v[nowVertex] = true;
            for (Node next : graph.get(nowVertex)) {
                if (!v[next.index]) {
                    if (d[next.index] > d[nowVertex] + next.cost) {
                        d[next.index] = d[nowVertex] + next.cost;
                        pq.add(new Node(next.index, d[next.index]));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (d[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(d[i] + "\n");
            }
        }

        System.out.println(sb);
    }
}
