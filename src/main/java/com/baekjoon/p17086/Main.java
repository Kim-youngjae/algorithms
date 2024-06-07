package com.baekjoon.p17086;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max;
    static int[][] map;

    static int[] dr = { 1, 1, 0, -1, -1, -1, 0, 1 };
    static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(max);
    }

    static void bfs(int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[N][M];

        v[sr][sc] = true;
        q.add(new int[] { sr, sc, 0 });
        int dist = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (map[now[0]][now[1]] == 1) {
                if (dist < now[2]) {
                    dist = now[2];
                    break;
                }
            }

            for (int i = 0; i < 8; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc]) {
                    continue;
                }

                v[nr][nc] = true;
                q.add(new int[] { nr, nc, now[2] + 1 });
            }
        }

        if (max < dist) {
            max = dist;
        }
    }
}
