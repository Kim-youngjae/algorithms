package com.baekjoon.p1260;

import java.util.*;

public class Main {
    static boolean[] visit;
    static int[][] nodes;
    static StringBuffer bf = new StringBuffer();

    static int n;
    static int m;
    static int v;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 정점의 개수
        m = sc.nextInt(); // 간선의 개수
        v = sc.nextInt(); // 탬색을 시작할 정점의 번호

        visit = new boolean[n];
        nodes = new int[n][n];

        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            nodes[v1 - 1][v2 - 1] = 1;
            nodes[v2 - 1][v1 - 1] = 1;
        }

        dfs(v - 1);
        bf.append("\n");
        visit = new boolean[n];
        bfs(v - 1);
        System.out.println(bf);

        sc.close();
    }

    private static void dfs(int start) {
        visit[start] = true;
        bf.append((start + 1) + " ");

        for (int i = 0; i < n; i++) {
            if (nodes[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        visit[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int target = q.remove();
            bf.append((target + 1) + " ");

            for (int i = 0; i < n; i++) {
                if (nodes[target][i] == 1 && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}