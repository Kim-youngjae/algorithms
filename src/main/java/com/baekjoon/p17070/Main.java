package com.baekjoon.p17070;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        dfs(1, 2, 0); // 행, 열, 방향

        System.out.println(ans);
    }

    static void dfs(int r, int c, int d) {
        if (r == N && c == N) { // 끝지점에 도달하면 경우의 수 카운트
            ans++;
            return;
        }

        switch (d) {
            case 0: // 가로 방향일 때
                if (c + 1 <= N && map[r][c + 1] == 0) {
                    dfs(r, c + 1, 0);
                }
                break;
            case 1: // 대각선 방향일 때
                if (c + 1 <= N && map[r][c + 1] == 0) {
                    dfs(r, c + 1, 0); // 가로 방향
                }

                if (r + 1 <= N && map[r + 1][c] == 0) {
                    dfs(r + 1, c, 2); // 세로 방향
                }
                break;
            case 2: // 세로 방향
                if (r + 1 <= N && map[r + 1][c] == 0) {
                    dfs(r + 1, c, 2);
                }
                break;
        }

        // 대각 방향을 고려하는 것은 공통 성분으로 switch 문을 돌고 한번씩 모두 검사
        if (r + 1 <= N && c + 1 <= N && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0 && map[r][c + 1] == 0) {
            dfs(r + 1, c + 1, 1);
        }
    }
}
