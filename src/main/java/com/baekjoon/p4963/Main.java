package com.baekjoon.p4963;

import java.io.*;
import java.util.*;

public class Main {
    static int w, h, cnt;
    static boolean[][] v;
    static int[][] m;
    static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            m = new int[h][w];
            v = new boolean[h][w];
            cnt = 0; // 카운트 초기화

            // 섬, 땅 입력
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++) {
                    m[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!v[i][j] && m[i][j] == 1) { // 방문할 수 있는 땅이면 탐색하기
                        cnt++;
                        bfs(i, j);
                    }
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }

    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(r, c));
        v[r][c] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 8; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];

                if (nr >= 0 && nr < h && nc >= 0 && nc < w && !v[nr][nc] && m[nr][nc] == 1) {
                    v[nr][nc] = true;
                    q.add(new Node(nr, nc));
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
