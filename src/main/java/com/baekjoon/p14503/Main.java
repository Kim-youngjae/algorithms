package com.baekjoon.p14503;

import java.io.*;
import java.util.*;

class Main {
    static int n, m, cnt;
    static int[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(sr, sc, d);

        System.out.println(cnt);

    }

    private static void bfs(int r, int c, int d) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(r, c));

        while (!q.isEmpty()) {
            Node temp = q.poll();

            // 현재 칸이 청소되어있지 않으면 청소
            if (map[temp.r][temp.c] == 0) {
                map[temp.r][temp.c] = -1;
                cnt++;
            }

            boolean flag = false;

            // 청소가 가능한지 4방향 체크
            for (int i = 0; i < 4; i++) {
                d -= 1;

                if (d < 0) {
                    d = 3;
                }

                int nr = temp.r + dr[d];
                int nc = temp.c + dc[d];

                // 청소가 되있지 않고 방문하지 않았으면
                if (map[nr][nc] == 0) {
                    q.add(new Node(nr, nc));
                    flag = true;
                    break;
                }
            }

            // 4곳 모두 청소가 되어있다면
            if (!flag) {
                int back = (d + 2) % 4;
                // 바라보는 방향을 유지한 채로 한 칸 후진
                int br = temp.r + dr[back];
                int bc = temp.c + dc[back];

                // 후진했을 때 벽이면 동작 중지
                if (map[br][bc] == 1) {
                    return;
                } else {
                    q.add(new Node(br, bc));
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