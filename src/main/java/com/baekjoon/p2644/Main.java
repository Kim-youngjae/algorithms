package com.baekjoon.p2644;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int s, e, n;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visit = new boolean[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = map[c][r] = 1;
        }

        dfs(s, e, 0);
        System.out.println(result);
    }

    private static void dfs(int s, int e, int chon) {

        if (s == e) {
            result = chon;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (map[s][i] == 1 && !visit[s][i]) {
                visit[s][i] = visit[i][s] = true;
                dfs(i, e, chon + 1);
            }
        }
    }
}
