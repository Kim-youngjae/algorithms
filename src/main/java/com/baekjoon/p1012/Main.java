package com.baekjoon.p1012;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visit;

    static int n;
    static int m;
    static int k;

    static int[] dr = { 1, 0, -1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken()); // 열
            m = Integer.parseInt(st.nextToken()); // 행
            k = Integer.parseInt(st.nextToken()); // 위치의 개수

            map = new int[n][m];
            visit = new boolean[n][m];

            // 초기화
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                map[r][c] = 1;
            }

            int result = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        result++;
                    }
                }
            }

            sb.append(result + "\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        int count = 0;

        q.add(new Node(r, c));
        visit[r][c] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int cr = node.r + dr[i];
                int cc = node.c + dc[i];

                if (cr >= 0 && cr < n && cc >= 0 && cc < m && !visit[cr][cc] && map[cr][cc] == 1) {
                    q.add(new Node(cr, cc));
                    visit[cr][cc] = true;
                }
            }
        }

        return count;
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