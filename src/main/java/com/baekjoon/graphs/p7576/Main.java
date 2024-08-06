package com.baekjoon.graphs.p7576;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, dist;
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new int[] { i, j }); // 처음 익은 토마토 위치 넣기
                }
                if (map[i][j] == 0) {
                    dist[i][j] = -1;
                }
            }
        }

        int days = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || dist[nr][nc] >= 0) {
                    continue;
                }

                dist[nr][nc] = dist[now[0]][now[1]] + 1;
                q.add(new int[] { nr, nc });

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[i][j] == -1) {
                    System.out.println(-1);
                    System.exit(-1);
                }
                days = Math.max(days, dist[i][j]);
            }
        }

        System.out.println(days);
    }

}
