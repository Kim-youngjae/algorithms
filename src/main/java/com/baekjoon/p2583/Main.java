package com.baekjoon.p2583;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visit;
    static int n, m;
    static List<Integer> result;
    static int[] dr = { 1, 0, -1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 행
        m = Integer.parseInt(st.nextToken()); // 열
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        // 초기화
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int sc = Integer.parseInt(st.nextToken());
            int sr = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());

            for (int s = sr; s < er; s++) {
                for (int e = sc; e < ec; e++) {
                    map[s][e] = 1;
                    visit[s][e] = true;
                }
            }
        }

        result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && map[i][j] == 0) {
                    // 0이 갈 수 있는 부분
                    result.add(bfs(i, j));
                }
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();

        sb.append(result.size() + "\n");

        for (int i : result) {
            sb.append(i + " ");
        }

        System.out.println(sb);
    }

    private static int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        int result = 0;

        q.add(new Node(r, c));
        visit[r][c] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            result++;

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visit[nr][nc] && map[nr][nc] == 0) {
                    q.add(new Node(nr, nc));
                    visit[nr][nc] = true;
                }
            }
        }

        return result;
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