package com.baekjoon.graphs.p2636;

import java.io.*;
import java.util.*;

public class Main {
    static int R, C, total, time;
    static int[][] map;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };
    static StringBuilder sb = new StringBuilder();

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

        map = new int[R][C];
        total = 0;
        time = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 처음 모든 치즈 개수를 구해준다.
                if (map[i][j] == 1) {
                    total++;
                }
            }
        }

        bfs();
        System.out.println(sb);
    }

    static void bfs() {
        ArrayDeque<Node> Q = new ArrayDeque<>();
        boolean[][] v = new boolean[R][C];

        int cnt = 0;
        time++;

        Q.add(new Node(0, 0));
        v[0][0] = true;

        while (!Q.isEmpty()) {
            Node now = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C || v[nr][nc])
                    continue;

                v[nr][nc] = true;

                if (map[nr][nc] == 1) {
                    map[nr][nc] = 0;
                    cnt++;
                } else {
                    Q.add(new Node(nr, nc));
                }
            }
        }

        total -= cnt;

        if (total == 0) {
            sb.append(time + "\n");
            sb.append(cnt);
            return;
        } else {
            bfs();
        }
    }
}
