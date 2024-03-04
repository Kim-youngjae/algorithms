package com.swea.D3.p2814;

import java.util.*;

public class Solution {
    static int N, M, maxDist;
    static int[][] nodes;
    static boolean[] v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            N = sc.nextInt();
            M = sc.nextInt();

            nodes = new int[N + 1][N + 1];
            v = new boolean[N + 1];
            maxDist = 0;

            for (int i = 0; i < M; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();

                nodes[r][c] = nodes[c][r] = 1;
            }

            for (int i = 1; i <= N; i++) {
                // v[i] = true;
                dfs(i, 1, 1); // 1번 부터 탐색 시작
                // v[i] = false;
            }

            sb.append(maxDist + "\n");
        }

        System.out.println(sb);
        sc.close();
    }

    static void dfs(int pos, int dist, int depth) {
        v[pos] = true;

        if (dist > maxDist) {
            maxDist = dist;
        }

        if (depth == N) {
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!v[i] && nodes[pos][i] == 1) { // 방문하지 않았고 연결되어 있으면
                // v[i] = true;
                dfs(i, dist + 1, depth + 1);
                // v[i] = false;
            }
        }
        v[pos] = false;
    }
}
