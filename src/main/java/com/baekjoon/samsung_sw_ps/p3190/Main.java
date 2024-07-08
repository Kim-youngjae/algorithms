package com.baekjoon.samsung_sw_ps.p3190;

import java.io.*;
import java.util.*;

public class Main {
    static int N, time, X, C;
    static int[][] map;
    static LinkedList<Node> q = new LinkedList<>();
    static Map<Integer, String> exec = new HashMap<>();

    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1; // 사과 위치 마킹
        }

        int L = Integer.parseInt(br.readLine());
        while (L-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            exec.put(x, c);
        }

        bfs();
        System.out.println(time);
    }

    static void bfs() {
        int cr = 0, cc = 0;
        time = 0;
        int d = 0;
        q.add(new Node(cr, cc));

        while (true) {
            time++;

            int nr = cr + dr[d];
            int nc = cc + dc[d];

            // 벽을 마주했을 때
            if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                return;
            }

            // 자기 자신과 부딫혔을 때
            for (Node node : q) {
                if (node.r == nr && node.c == nc) {
                    return;
                }
            }

            if (map[nr][nc] == 1) {
                map[nr][nc] = 0;
                q.add(new Node(nr, nc));
            } else {
                q.add(new Node(nr, nc));
                q.poll();
            }

            if (exec.containsKey(time)) {
                if (exec.get(time).equals("D")) {
                    d += 1;
                    if (d == 4) {
                        d = 0;
                    }
                } else {
                    d -= 1;
                    if (d == -1) {
                        d = 3;
                    }
                }
            }

            cr = nr;
            cc = nc;

        }

    }

}
