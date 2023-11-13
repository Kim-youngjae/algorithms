package com.baekjoon.p14503;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dirRow = { -1, 0, 1, 0 };
    static int[] dirCol = { 0, 1, 0, -1 };
    static int count = 0;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int r = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());
        int d = Integer.valueOf(st.nextToken()); // 로봇 방향 0:북, 1:동, 2: 남, 3:서

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        bfs(r, c, d);

        System.out.println(count);
    }

    private static void bfs(int row, int col, int dir) {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { row, col, dir });
        visited[row][col] = true;
        map[row][col] = -1;
        count++;

        while (!q.isEmpty()) {
            int[] robot = q.poll();
            int cr = robot[0];
            int cc = robot[1];
            dir = robot[2];

            // 반시계 회전
            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4;

                int mr = cr + dirRow[dir];
                int mc = cc + dirCol[dir];

                if (map[mr][mc] == 0 && !visited[mr][mc]) {
                    map[mr][mc] = -1; // 청소처리
                    q.add(new int[] { mr, mc, dir });
                    visited[mr][mc] = true;
                    count++;
                }
            }

            int d = (dir + 2) % 4; // 현재 바라보는 방향의 반대 방향
            int br = cr + dirRow[d];
            int bc = cc + dirCol[d];

            if (map[br][bc] != 1) {
                q.add(new int[] { br, bc, dir });
                visited[br][bc] = true;
            }
        }

    }
}
