package com.baekjoon.p7562;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static boolean[][] visit;
    static int l, sr, sc, er, ec;

    static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            l = Integer.parseInt(br.readLine());

            board = new int[l][l];
            visit = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            sr = Integer.parseInt(st.nextToken());
            sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            er = Integer.parseInt(st.nextToken());
            ec = Integer.parseInt(st.nextToken());

            bfs(sr, sc);
            sb.append(board[er][ec] + "\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(r, c));
        visit[r][c] = true;

        while (!q.isEmpty()) {
            Node temp = q.poll();
            int cr = temp.r;
            int cc = temp.c;

            if (cr == er && cc == ec) {
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >= 0 && nr < l && nc >= 0 && nc < l && !visit[nr][nc] && board[nr][nc] == 0) {
                    q.add(new Node(nr, nc));
                    board[nr][nc] = board[cr][cc] + 1;
                    visit[nr][nc] = true;
                }
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