package com.baekjoon.p2667;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        List<Integer> section = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    section.add(bfs(i, j));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(section.size() + "\n");

        Collections.sort(section);

        for (int i : section) {
            sb.append(i + "\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        int size = 0;

        q.add(new int[] { r, c });
        visit[r][c] = true;
        size++;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int cr = temp[0];
            int cc = temp[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visit[nr][nc] && map[nr][nc] == 1) {
                    q.add(new int[] { nr, nc });
                    visit[nr][nc] = true;
                    size++;
                }
            }
        }

        return size;

    }
}