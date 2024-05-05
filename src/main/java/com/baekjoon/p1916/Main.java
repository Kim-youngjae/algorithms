package com.baekjoon.p1916;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Node>> list;
    static boolean[] v;
    static int[] d;
    static final int INF = 1000000;

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

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        d = new int[N + 1];
        Arrays.fill(d, INF);

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(r).add(new Node(c, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(d[end]);
    }

    static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        v = new boolean[N + 1];
        d[start] = 0;

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if (v[nowVertex]) {
                continue;
            }

            v[nowVertex] = true;
            for (Node next : list.get(nowVertex)) {
                if (!v[next.index]) {
                    if (d[next.index] > d[nowVertex] + next.cost) {
                        d[next.index] = d[nowVertex] + next.cost;
                        pq.add(new Node(next.index, d[next.index]));
                    }
                }
            }
        }

    }
}
