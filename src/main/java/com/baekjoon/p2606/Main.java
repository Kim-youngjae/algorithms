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

        bfs(0);

        int count = 0;

        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) {
                count++;
            }
        }

        System.out.println(count);
    }


    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        // 큐에 넣기
        q.add(start);
        // 방문처리
        visited[start] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();
            visited[start] = true;

            for (int i = 0; i < visited.length; i++) {
                if(nodes[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
