package com.baekjoon.p7576;

import java.io.*;
import java.util.*;

class Tomato {
    int r;
    int c;
    int day;

    Tomato(int r, int c, int day) {
        this.r = r;
        this.c = c;
        this.day = day;
    }
}

class Main {
    static int n, m, days, check;
    static int[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        int rowTomato = 0; // 처음 안익은 토마토 갯수 카운트

        Queue<Tomato> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (value == 0) {
                    rowTomato++;
                } else if (value == 1) {
                    q.add(new Tomato(i, j, 0));
                }

                map[i][j] = value;
            }
        }

        bfs(q);

        // 모든 토마토가 다익음
        if (check == rowTomato) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }

    private static void bfs(Queue<Tomato> q) {

        while (!q.isEmpty()) {
            Tomato t = q.poll();

            int cr = t.r;
            int cc = t.c;
            days = t.day;

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                if (map[nr][nc] == 0) {
                    q.add(new Tomato(nr, nc, t.day + 1));
                    map[nr][nc] = 1;
                    check++;
                }
            }
        }

    }
}