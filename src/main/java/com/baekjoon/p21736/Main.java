package com.baekjoon.p21736;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, meet;
    static char[][] map;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        int sr = 0, sc = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'I') {
                    sr = i;
                    sc = j;
                }

                map[i][j] = str.charAt(j);
            }

        }

        bfs(sr, sc);

        if (meet == 0) {
            System.out.println("TT");
        } else {
            System.out.println(meet);
        }

    }

    static void bfs(int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[N][M];

        v[sr][sc] = true;
        q.add(new int[] { sr, sc });

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] != 'X') {
                    if (map[nr][nc] == 'P') {
                        meet++;
                    }

                    v[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
            }
        }
    }
}
