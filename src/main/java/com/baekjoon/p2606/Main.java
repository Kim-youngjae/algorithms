package com.baekjoon.p2606;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[] visit;
    static int n, m, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        visit = new boolean[n];
        map = new int[n][n];

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r - 1][c - 1] = map[c - 1][r - 1] = 1;
        }

        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int start) {
        visit[start] = true;

        for (int i = 0; i < n; i++) {
            if (!visit[i] && map[start][i] == 1) {
                result++;
                dfs(i);
            }
        }
    }
}
