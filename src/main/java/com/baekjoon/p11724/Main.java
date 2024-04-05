package com.baekjoon.p11724;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        v = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = map[c][r] = 1;
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                cnt++;
                v[i] = true;
                dfs(i);
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int now) {
        for (int i = 0; i < N; i++) {
            if (map[now][i] == 1 && !v[i]) { // 연결되어 있고 방문하지 않았다면 탐색
                v[i] = true;
                dfs(i);
            }
        }
    }
}
