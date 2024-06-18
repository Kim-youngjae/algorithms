package com.baekjoon.p13565;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] dr = { 1, 0, -1, 0 };
    static int[] dc = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        boolean flag = true;
        for (int i = 0; i < M; i++) {
            if (bfs(i)) {
                flag = true;
                break;
            } else {
                flag = false;
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static boolean bfs(int sc) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[N][M];

        v[N - 1][sc] = true;
        q.add(new int[] { N - 1, sc });

        while (!q.isEmpty()) {

            int[] now = q.poll();

            if (now[0] == 0) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == '0') {
                    v[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
            }
        }

        return false;
    }
}
