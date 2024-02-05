package com.baekjoon.p2468;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visit;
    static int n, maxHeight, result;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        // visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, val);
                map[i][j] = val;
            }
        }

        result = 0;

        for (int rain = 0; rain <= maxHeight; rain++) {
            int cnt = 0;
            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && map[i][j] > rain) {
                        bfs(i, j, rain);
                        cnt++;
                    }
                }
            }
            result = Math.max(result, cnt);
        }

        System.out.println(result);
    }

    private static void bfs(int r, int c, int rain) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { r, c });
        visit[r][c] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int cr = temp[0];
            int cc = temp[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visit[nr][nc] && map[nr][nc] > rain) {
                    q.add(new int[] { nr, nc });
                    visit[nr][nc] = true;
                }
            }
        }
    }
}
