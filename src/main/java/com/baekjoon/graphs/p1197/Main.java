package com.baekjoon.graphs.p1197;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int from, to, cost;

    Node(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parents = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Node(from, to, cost));
        }

        int size = pq.size();
        int total = 0; // 간선 가중치의 합

        /**
         * node를 확인하면서 사이클이 발생하는 노드인지 확인
         */
        for (int i = 0; i < size; i++) {
            Node node = pq.poll();

            int x = find(node.from);
            int y = find(node.to);

            if (!isSameParents(x, y)) {
                total += node.cost;
                union(x, y);
            }
        }

        System.out.println(total);
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        } else {
            return parents[x] = find(parents[x]);
        }
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx != ry) {
            if (rx < ry) {
                parents[ry] = rx;
            } else {
                parents[rx] = ry;
            }
        }
    }

    static boolean isSameParents(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx == ry) {
            return true;
        } else {
            return false;
        }
    }
}
