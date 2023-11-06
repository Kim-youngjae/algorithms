package com.baekjoon.p1260;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] nodes;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.valueOf(st.nextToken());// 정점의 개수
        // 간선의 수
        int m = Integer.valueOf(st.nextToken());
        // 시작 노드의 위치
        int s = Integer.valueOf(st.nextToken());

        nodes = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int row = Integer.valueOf(st.nextToken());
            int col = Integer.valueOf(st.nextToken());

            nodes[row - 1][col - 1] = 1;
            nodes[col - 1][row - 1] = 1; // 양방향 간선이라서
        }

        dfs(s - 1);

        sb.append("\n");

        visited = new boolean[n]; // 방문노드 초기화

        bfs(s - 1);

        System.out.print(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int node = q.poll();
            sb.append(node + 1 + " ");

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
        sb.append(start + 1 + " ");
        visited[start] = true; // 방문한 노드에 대해서 방문 표시

        for (int i = 0; i < visited.length; i++) {
            if (nodes[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
