package com.baekjoon.p1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] nodes;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt(); // 시작 노드

        nodes = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            nodes[r - 1][c - 1] = 1;
            nodes[c - 1][r - 1] = 1;
        }

        dfs(V - 1); //dfs 시작

        System.out.println();

        visited = new boolean[N];
        bfs(V - 1);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int node = q.poll();
            System.out.printf("%d ", node + 1);

            for (int i = 0; i < visited.length; i++) {
                if (nodes[node][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }

    private static void dfs(int start) {
        // 방문한 노드는 출력
        System.out.printf("%d ", start + 1);
        visited[start] = true;

        for (int i = 0; i < visited.length; i++) {
            if (nodes[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
