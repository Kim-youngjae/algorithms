package com.swea.D2.p1954;

import java.io.*;

public class Solution {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirRow = { 0, 1, 0, -1 };
    static int[] dirCol = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            startSnail(0, 0, 0);
            sb.append("#").append(t).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void startSnail(int r, int c, int d) {
        for (int i = 1; i <= N * N; i++) {
            map[r][c] = i;

            if (r + dirRow[d] < 0 || r + dirRow[d] >= N || c + dirCol[d] < 0 || c + dirCol[d] >= N
                    || map[r + dirRow[d]][c + dirCol[d]] != 0) {
                d = (d + 1) % 4;
            }

            r += dirRow[d];
            c += dirCol[d];
        }
    }
}
