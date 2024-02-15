package com.baekjoon.p7569;

import java.io.*;
import java.util.*;

class Main {
    static int n, m, d, days, check;
    static int[][][] box;

    static int[] dr = { -1, 0, 1, 0, 0, 0 };
    static int[] dc = { 0, 1, 0, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, 1, -1 };

    static Queue<Tomato> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        box = new int[n][m][d];

        int row = 0;

        for (int i = 0; i < d; i++) {

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < m; k++) {
                    int val = Integer.parseInt(st.nextToken());

                    if (val == 0) {
                        row++;
                    } else if (val == 1) {
                        q.add(new Tomato(j, k, i, 0));
                    }

                    box[j][k][i] = val;
                }
            }
        }

        bfs();
        if (check == row) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }

    private static void bfs() {

        while (!q.isEmpty()) {
            Tomato t = q.poll();
            days = t.day;

            for (int i = 0; i < 6; i++) {
                int nr = t.r + dr[i];
                int nc = t.c + dc[i];
                int nz = t.z + dz[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || nz < 0 || nz >= d) {
                    continue;
                }

                if (box[nr][nc][nz] == 0) {
                    q.add(new Tomato(nr, nc, nz, t.day + 1));
                    box[nr][nc][nz] = 1;
                    check++;
                }
            }
        }
    }
}

class Tomato {
    int r;
    int c;
    int z;
    int day;

    Tomato(int r, int c, int z, int day) {
        this.r = r;
        this.c = c;
        this.z = z;
        this.day = day;
    }
}