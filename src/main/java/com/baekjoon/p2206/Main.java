package com.baekjoon.p2206;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dist;
    static boolean[][][] v;

    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        v = new boolean[2][N][M]; // 0: 벽 안부수고 방문, 1: 벽 부수고 방문

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { 0, 0, 0 });
        v[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            int cr = now[0];
            int cc = now[1];

            if (cr == N - 1 && cc == M - 1) {
                return dist[cr][cc] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                // 벽을 만난다면 벽을 뚫을 수 있는 기회가 있는지 체크
                if (map[nr][nc] == 1) {
                    if (now[2] == 0 && !v[1][nr][nc]) {
                        v[1][nr][nc] = true;
                        dist[nr][nc] = dist[cr][cc] + 1;
                        q.add(new int[] { nr, nc, 1 });
                    }
                } else {
                    if (!v[now[2]][nr][nc]) {
                        v[now[2]][nr][nc] = true;
                        dist[nr][nc] = dist[cr][cc] + 1;
                        q.add(new int[] { nr, nc, now[2] });
                    }
                }

                if (nr == N - 1 && nc == M - 1) {
                    return dist[nr][nc] + 1;
                }
            }
        }

        return -1;
    }
}
