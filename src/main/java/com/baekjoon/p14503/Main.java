package com.baekjoon.p14503;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
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

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        count++; // 현재칸 청소
        // bfs(r, c, d);
        dfs(r, c, d);

        System.out.println(count);
    }

    private static void dfs(int r, int c, int d) {

        map[r][c] = -1;

        for (int i = 0; i < 4; i++) {
            int left = (d + 3) % 4;
            int nr = r + dr[left];
            int nc = c + dc[left];

            if (map[nr][nc] == 0) {
                dfs(nr, nc, left);
                count++;
                return;
            }
        }

        int back = (d + 2) % 4;
        int nr = r + dr[back];
        int nc = c + dc[back];

        if (map[nr][nc] != 1) {
            dfs(nr, nc, d);
        }
    }

    private static void bfs(int r, int c, int d) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(r, c));

        while (!q.isEmpty()) {
            Node node = q.poll();

            // 현재 칸 청소되지 않은 경우 현재 칸을 청소
            if (map[node.r][node.c] == 0) {
                map[node.r][node.c] = -1;
                count++;
            }

            boolean flag = false;

            // 주변 4칸 확인
            for (int i = 0; i < 4; i++) {
                int left = (d + 3) % 4;
                int cr = node.r + dr[left];
                int cc = node.c + dc[left];
                // 청소되지 않은 칸이 있으면 큐에 넣기
                if (map[cr][cc] == 0) {
                    d = left; // 왼쪽으로 돌린 방향으로 업데이트
                    q.add(new Node(cr, cc));
                    flag = true;
                    break;
                } else {
                    d = left;
                }
            }

            if (!flag) {
                // 주변 4칸을 확인했을 때 모두 청소되어 있지 않은 경우
                int back = (d + 2) % 4;
                int cr = node.r + dr[back];
                int cc = node.c + dc[back];

                if (map[cr][cc] == 1) {
                    break;
                } else {
                    q.add(new Node(cr, cc));
                }
            }
        }
    }
}

class Node {
    int r;
    int c;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}