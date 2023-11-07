package com.baekjoon.p2468;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] node;
    static boolean[][] visited;
    static int n;

    static int[] dirRow = { 1, 0, -1, 0 };
    static int[] dirCol = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.valueOf(br.readLine());

        node = new int[n][n];

        int maxHeight = 0;

        // 가장 높은 높이랑 영역 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < n; j++) {
                node[i][j] = Integer.valueOf(st.nextToken());

                if (node[i][j] >= maxHeight) {
                    maxHeight = node[i][j];
                }
            }
        }

        int count = 0;
        int safeZone = 0;

        // 강수량을 증가시키면서 반복
        for (int rain = 0; rain < maxHeight; rain++) {
            count = 0;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (rain < node[i][j] && !visited[i][j]) {
                        count++;
                        bfs(i, j, rain);
                    }
                }
            }

            safeZone = Math.max(count, safeZone);
        }

        System.out.println(safeZone);
    }

    private static void bfs(int r, int c, int rain) {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { r, c });
        visited[r][c] = true;

        while (!q.isEmpty()) {

            int[] target = q.poll();

            int cr = target[0];
            int cc = target[1];

            for (int i = 0; i < 4; i++) {
                int mr = cr + dirRow[i];
                int mc = cc + dirCol[i];

                if (mr >= 0 && mr < n && mc >= 0 && mc < n) {
                    if (node[mr][mc] > rain && !visited[mr][mc]) {
                        q.add(new int[] { mr, mc });
                        visited[mr][mc] = true;
                    }
                }
            }
        }
    }
}
