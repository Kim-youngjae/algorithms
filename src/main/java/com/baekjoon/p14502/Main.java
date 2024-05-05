package com.baekjoon.p14502;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };
    static int maxSafeZone = Integer.MIN_VALUE;
    static int[][] originMap;

    static class Virus {
        int r;
        int c;

        Virus(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        originMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(maxSafeZone);
    }

    static void dfs(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (originMap[i][j] == 0) {
                    originMap[i][j] = 1;
                    dfs(cnt + 1);
                    originMap[i][j] = 0;
                }
            }
        }

    }

    static void bfs() {
        Queue<Virus> q = new ArrayDeque<>();

        // 원본 지도 복사
        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            copyMap[i] = originMap[i].clone();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (originMap[i][j] == 2) {
                    q.add(new Virus(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Virus now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && copyMap[nr][nc] == 0) {
                    q.add(new Virus(nr, nc));
                    copyMap[nr][nc] = 2;
                }
            }
        }

        countSafeZone(copyMap);
    }

    static void countSafeZone(int[][] copyMap) {
        int safeZone = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        maxSafeZone = Math.max(maxSafeZone, safeZone);
    }

}
