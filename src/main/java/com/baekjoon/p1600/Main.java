package com.baekjoon.p1600;

import java.io.*;
import java.util.*;

public class Main {
    static int K, H, W;
    static int[][] map;
    static boolean[][][] v;
    static Queue<int[]> q;

    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int[] hr = { -2, -2, -1, 1, 2, 2, -1, 1 };
    static int[] hc = { -1, 1, 2, 2, -1, 1, -2, -2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        v = new boolean[K + 1][H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        q = new LinkedList<>();

        q.add(new int[] { 0, 0, 0, 0 });

        while (!q.isEmpty()) {
            int[] now = q.poll();

            int cr = now[0];
            int cc = now[1];
            int move = now[2];
            int chance = now[3];

            if (cr == H - 1 && cc == W - 1) {
                return move;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr < 0 || nr > H - 1 || nc < 0 || nc > W - 1) {
                    continue;
                }

                if (!v[chance][nr][nc] && map[nr][nc] != 1) {
                    v[chance][nr][nc] = true;
                    q.add(new int[] { nr, nc, move + 1, chance });
                }
            }

            if (chance < K) {
                for (int i = 0; i < hr.length; i++) {
                    int nr = cr + hr[i];
                    int nc = cc + hc[i];

                    if (nr < 0 || nr > H - 1 || nc < 0 || nc > W - 1) {
                        continue;
                    }

                    if (!v[chance + 1][nr][nc] && map[nr][nc] != 1) {
                        v[chance + 1][nr][nc] = true;
                        q.add(new int[] { nr, nc, move + 1, chance + 1 });
                    }
                }
            }
        }
        return -1;
    }
}
