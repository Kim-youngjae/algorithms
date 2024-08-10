package com.baekjoon.graphs.p2589;

import java.io.*;
import java.util.*;

public class Main {
    static int R, C, ans;
    static char[][] map;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(ans);
    }

    static void bfs(int sr, int sc) {
        ArrayDeque<Node> Q = new ArrayDeque<>();
        int[][] dist = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(dist[i], -1);
        }

        Q.add(new Node(sr, sc));
        dist[sr][sc] = 0;

        while (!Q.isEmpty()) {
            Node now = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C)
                    continue;
                if (dist[nr][nc] >= 0 || map[nr][nc] == 'W')
                    continue;

                Q.add(new Node(nr, nc));
                dist[nr][nc] = dist[now.r][now.c] + 1;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans = Math.max(ans, dist[i][j]);
            }
        }
    }
}
