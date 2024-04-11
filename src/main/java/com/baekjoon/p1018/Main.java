package com.baekjoon.p1018;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                ans = Math.min(check(i, j), ans);
            }
        }

        System.out.println(ans);
    }

    static int check(int sr, int sc) {
        int cnt = 0;

        char std = board[sr][sc];

        for (int i = sr; i < (sr + 8); i++) {
            for (int j = sc; j < (sc + 8); j++) {
                if (board[i][j] != std) {
                    cnt++;
                }

                if (std == 'B') {
                    std = 'W';
                } else {
                    std = 'B';
                }
            }

            if (std == 'B') {
                std = 'W';
            } else {
                std = 'B';
            }
        }

        cnt = Math.min(cnt, 64 - cnt); // 반대 기준으로 검사했을 때의 칠해지는 갯수

        return cnt;
    }
}
