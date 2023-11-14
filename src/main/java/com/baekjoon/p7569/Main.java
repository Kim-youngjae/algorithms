package com.baekjoon.p7569;

import java.io.*;
import java.util.*;

public class Main {
    static int[][][] map;
    static int m, n, h;
    static Queue<Tomato> q1 = new LinkedList<>(); // 1위치를 저장

    static int[] dirX = { -1, 0, 1, 0, 0, 0 };
    static int[] dirY = { 0, 1, 0, -1, 0, 0 };
    static int[] dirZ = { 0, 0, 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.valueOf(st.nextToken()); // 열
        n = Integer.valueOf(st.nextToken()); // 행
        h = Integer.valueOf(st.nextToken()); // 면

        map = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.valueOf(st.nextToken());
                    if (map[i][j][k] == 1) {
                        q1.add(new Tomato(i, j, k));
                    }

                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!q1.isEmpty()) {
            Tomato t = q1.remove();

            int z = t.z; // 면
            int x = t.x; // 행
            int y = t.y; // 열

            for (int i = 0; i < 6; i++) {
                int nx = x + dirX[i];
                int ny = y + dirY[i];
                int nz = z + dirZ[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < m && nz < h) {
                    // 토마토가 익지 않았다면
                    if (map[nz][nx][ny] == 0) {
                        // 익지 않은 토마토를 추가
                        q1.add(new Tomato(nz, nx, ny));

                        map[nz][nx][ny] = map[z][x][y] + 1;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0)
                        return -1;
                    result = Math.max(result, map[i][j][k]);
                }
            }
        }

        // 토마토가 모두 익은 경우
        if (result == 1)
            return 0;

        return result - 1;
    }
}

class Tomato {
    int x, y, z;

    public Tomato(int z, int x, int y) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
