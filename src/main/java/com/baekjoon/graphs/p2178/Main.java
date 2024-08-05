package com.baekjoon.graphs.p2178;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N, M;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(map[N - 1][M - 1]);
    }

    static void bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[N][M];

        q.add(new int[] { 0, 0 });
        v[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M && !v[nr][nc] && map[nr][nc] == 1) {
                    q.add(new int[] { nr, nc });
                    v[nr][nc] = true;
                    map[nr][nc] = map[now[0]][now[1]] + 1;
                }
            }
        }

    }
}
