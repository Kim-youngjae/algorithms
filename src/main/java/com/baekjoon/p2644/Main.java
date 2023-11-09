package com.baekjoon.p2644;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] node;
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.valueOf(st.nextToken()) - 1;
        int y = Integer.valueOf(st.nextToken()) - 1;

        node = new int[n][n];
        visited = new boolean[n];

        int m = Integer.valueOf(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int r = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());

            node[r - 1][c - 1] = node[c - 1][r - 1] = 1;
        }

        dfs(x, y, 0);

        System.out.println(result);
    }

    private static void dfs(int start, int end, int depth) {
        visited[start] = true; // 방문한 노드에 대해서 방문 표시

        if (start == end) {
            result = depth;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (node[start][i] == 1 && !visited[i]) {
                dfs(i, end, depth + 1);
            }
        }
    }
}
