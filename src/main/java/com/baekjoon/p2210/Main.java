package com.baekjoon.p2210;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = new int[] { 0, 1, 0, -1 };
    static int[] dc = new int[] { 1, 0, -1, 0 };

    static int[][] map = new int[5][5];
    static Set<String> s = new HashSet<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, String.valueOf(map[i][j]));
            }
        }

        System.out.println(s.size());
        sc.close();
    }

    static void dfs(int r, int c, String str) {
        if (str.length() == 6) {
            s.add(str);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
                dfs(nr, nc, str + map[nr][nc]);
            }

        }
    }

    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c, String.valueOf(map[r][c])));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.str.length() == 6) {
                s.add(node.str);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];

                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
                    q.add(new Node(nr, nc, node.str + map[nr][nc]));
                }
            }
        }
    }

    static class Node {
        int r, c;
        String str;

        Node(int r, int c, String str) {
            this.r = r;
            this.c = c;
            this.str = str;
        }
    }
}
