package com.baekjoon.p1926;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] nodes;
    static boolean[][] visit;
    static int n;
    static int m;
    static int[] dr = { 1, 0, -1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int painting;
    static int size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nodes = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                nodes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        painting = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nodes[i][j] == 1 && !visit[i][j]) {
                    // max = Math.max(max, bfs(i, j));
                    painting++;
                    size = 0;
                    dfs(i, j);
                    max = Math.max(max, size);
                }
            }
        }

        System.out.println(painting);
        System.out.println(max);
    }

    private static int bfs(int r, int c) {
        painting++;
        Queue<Node> q = new LinkedList<>();
        int size = 0;

        q.add(new Node(r, c));
        visit[r][c] = true;
        size++;

        while (!q.isEmpty()) {
            Node temp = q.poll();

            for (int k = 0; k < 4; k++) {
                int cr = temp.r + dr[k];
                int cc = temp.c + dc[k];

                if (cr >= 0 && cr < n && cc >= 0 && cc < m && !visit[cr][cc] && nodes[cr][cc] == 1) {
                    q.add(new Node(cr, cc));
                    visit[cr][cc] = true;
                    size++;
                }
            }
        }

        return size;
    }

    private static void dfs(int r, int c) {
        visit[r][c] = true;
        size++;

        for (int i = 0; i < 4; i++) {
            int cr = r + dr[i];
            int cc = c + dc[i];

            if (cr >= 0 && cr < n && cc >= 0 && cc < m && !visit[cr][cc] && nodes[cr][cc] == 1) {
                dfs(cr, cc);
            }
        }
    }
}

class Node {
    int r;
    int c;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
