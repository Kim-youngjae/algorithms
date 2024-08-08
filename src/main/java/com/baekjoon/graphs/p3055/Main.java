package com.baekjoon.graphs.p3055;

import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] dist1, dist2;

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        dist1 = new int[R][C];
        dist2 = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(dist1[i], -1);
            Arrays.fill(dist2[i], -1);
        }

        ArrayDeque<Node> Q1 = new ArrayDeque<>(); // 물의 위치를 저장할 큐
        ArrayDeque<Node> Q2 = new ArrayDeque<>(); // 고슴도치의 위치를 저장할 큐

        for (int i = 0; i < R; i++) {
            String in = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = in.charAt(j);
                if (map[i][j] == '*') {
                    Q1.add(new Node(i, j));
                    dist1[i][j] = 0;
                }
                if (map[i][j] == 'S') {
                    Q2.add(new Node(i, j));
                    dist2[i][j] = 0;
                }
            }
        }

        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };

        while (!Q2.isEmpty()) {
            // 물에 대한 BFS
            int wSize = Q1.size();

            for (int n = 0; n < wSize; n++) {

                Node now = Q1.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];

                    if (nr < 0 || nc < 0 || nr >= R || nc >= C)
                        continue;
                    if (map[nr][nc] == 'D' || dist1[nr][nc] > 0 || map[nr][nc] == 'X')
                        continue;

                    Q1.add(new Node(nr, nc));
                    dist1[nr][nc] = dist1[now.r][now.c] + 1;
                }
            }

            // 고슴도치에 대한 BFS
            int sSize = Q2.size();

            for (int n = 0; n < sSize; n++) {
                Node now = Q2.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= R || nc >= C)
                        continue;
                    if (map[nr][nc] == 'D') {
                        System.out.println(dist2[now.r][now.c] + 1);
                        System.exit(0);
                    }
                    if (map[nr][nc] == 'X' || dist2[nr][nc] > 0 || dist1[nr][nc] > 0)
                        continue;

                    Q2.add(new Node(nr, nc));
                    dist2[nr][nc] = dist2[now.r][now.c] + 1;
                }
            }

        }

        System.out.println("KAKTUS");
    }
}
