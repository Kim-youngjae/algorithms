package com.baekjoon.p2606;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.valueOf(br.readLine());

        nodes = new int[n][n];
        visited = new boolean[n];

        int m = Integer.valueOf(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int row = Integer.valueOf(st.nextToken());
            int col = Integer.valueOf(st.nextToken());

            nodes[row - 1][col - 1] = 1;
            nodes[col - 1][row - 1] = 1;
        }

        System.out.println(bfs(0) - 1);
    }


    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        // 큐에 넣기
        q.add(start);
        // 방문처리
        visited[start] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();
            visited[start] = true;
            count++;

            for (int i = 0; i < visited.length; i++) {
                if(nodes[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        return count;
    }
}
