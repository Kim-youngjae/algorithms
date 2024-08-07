package com.baekjoon.graphs.p4179;

import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] dist1, dist2;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static ArrayDeque<Node> q = new ArrayDeque<>();
    static ArrayDeque<Node> fireQ = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        dist1 = new int[R][C]; // 불 전파시간
        dist2 = new int[R][C]; // 지훈이의 이동시간

        for (int i = 0; i < R; i++) {
            Arrays.fill(dist1[i], -1);
            Arrays.fill(dist2[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                // 불이 처음 난 지점 입력받기
                if (map[i][j] == 'F') {
                    fireQ.add(new Node(i, j));
                    dist1[i][j] = 0;
                }
                // 지훈이의 미로에서 초기 위치
                if (map[i][j] == 'J') {
                    q.add(new Node(i, j));
                    dist2[i][j] = 0;
                }
            }
        }

        // 불에 대한 BFS
        while (!fireQ.isEmpty()) {
            Node now = fireQ.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C)
                    continue;
                if (dist1[nr][nc] >= 0 || map[nr][nc] == '#')
                    continue;

                dist1[nr][nc] = dist1[now.r][now.c] + 1;
                fireQ.add(new Node(nr, nc));
            }
        }

        // 지훈이 이동에 대한 BFS
        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    System.out.println(dist2[now.r][now.c] + 1);
                    System.exit(0);
                }
                if (dist2[nr][nc] >= 0 || map[nr][nc] == '#')
                    continue;
                if (dist1[nr][nc] != -1 && dist1[nr][nc] <= dist2[now.r][now.c] + 1)
                    continue;

                dist2[nr][nc] = dist2[now.r][now.c] + 1;
                q.add(new Node(nr, nc));
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
