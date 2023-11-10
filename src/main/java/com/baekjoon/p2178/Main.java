package com.baekjoon.p2178;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] node;
    static boolean[][] visited;
    static int[] dirRow = { 1, 0, -1, 0 };
    static int[] dirCol = { 0, 1, 0, -1 };
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        node = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            char[] charArr = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                node[i][j] = charArr[j] - '0';
            }
        }

        bfs(0, 0, 1);

        System.out.println(node[n - 1][m - 1]);
    }

    private static void bfs(int start, int end, int step) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { start, end });
        visited[start][end] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            int cr = temp[0];
            int cc = temp[1];

            for (int i = 0; i < 4; i++) {
                int mr = cr + dirRow[i];
                int mc = cc + dirCol[i];

                if (mr >= 0 && mr < n && mc >= 0 && mc < m) {
                    if (node[mr][mc] == 1 && !visited[mr][mc]) {
                        q.add(new int[] { mr, mc });
                        visited[mr][mc] = true;
                        node[mr][mc] = node[cr][cc] + 1;
                    }
                }
            }
        }
    }
}
