package com.baekjoon.p14940;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] dist;
    static boolean[][] v;
    static Point goal;

    static int[] dr = { 0, -1, 0, 1 };
    static int[] dc = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    goal = new Point(i, j);
                }
            }
        }

        bfs(goal);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && dist[i][j] == 0) {
                    sb.append("-1" + " ");
                } else {
                    sb.append(dist[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(Point start) {
        Queue<Point> q = new LinkedList<>();

        q.add(start);
        v[start.r][start.c] = true;

        while (!q.isEmpty()) {
            Point temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = temp.r + dr[i];
                int nc = temp.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 1) {
                    v[nr][nc] = true;
                    q.add(new Point(nr, nc));
                    dist[nr][nc] = dist[temp.r][temp.c] + 1;
                }
            }
        }
    }
}

class Point {
    int r;
    int c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
