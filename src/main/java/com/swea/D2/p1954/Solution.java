package com.swea.D2.p1954;

import java.io.*;
import java.util.*;

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
            visited = new boolean[N][N];

            bfs(0, 0, 0);

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

    private static void bfs(int r, int c, int d) {
        Queue<Position> q = new LinkedList<>();

        q.add(new Position(r, c, d));
        map[r][c] += 1;
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Position p = q.remove();

            int nr = p.r + dirRow[p.d];
            int nc = p.c + dirCol[p.d];
            map[nr][nc] += 1; // 1씩 더해주기

            if (nr > 0 && nr < N && nc > 0 && nc < N) {
                // 범위 안에 있으면 계속 전진
                if (!visited[nr][nc]) {
                    q.add(new Position(nr, nc, p.d));
                    visited[nr][nc] = true;
                }
            } else {
                // 범위를 벗어나면 90도 틀어서 방향 바꿔주기
                p.d += 1;
                int rotatedRow = p.r + dirRow[p.d];
                int rotatedCol = p.c + dirCol[p.d];
                q.add(new Position(rotatedRow, rotatedCol, p.d));
            }
        }
    }
}

class Position {
    int r;
    int c;
    int d;

    public Position(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}
