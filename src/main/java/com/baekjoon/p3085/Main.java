package com.baekjoon.p3085;

import java.io.*;
import java.util.*;

public class Main {
    static int N, maxLen;
    static char[][] board;
    static int[] dr = { 0, -1 };
    static int[] dc = { 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Bomboni(i, j);
            }
        }

        System.out.println(maxLen);
    }

    static void Bomboni(int cr, int cc) {

        for (int i = 0; i < 2; i++) {
            int nr = cr + dr[i];
            int nc = cc + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (board[nr][nc] != board[cr][cc]) {
                    swap(cr, cc, nr, nc);
                    findMaxLen(cr, cc);
                    swap(nr, nc, cr, cc);
                }
            }
        }
    }

    static void swap(int cr, int cc, int nr, int nc) {
        char target = board[cr][cc];
        board[cr][cc] = board[nr][nc];
        board[nr][nc] = target;
    }

    static void findMaxLen(int cr, int cc) {
        // 전체 배열에서 제일 긴 사탕길이 찾기

        for (int i = 0; i < N; i++) {

            // 행 검사
            int cntX = 1;
            for (int j = 0; j < N - 1; j++) {

                if (board[i][j] == board[i][j + 1]) {
                    cntX++;
                    maxLen = Math.max(cntX, maxLen);
                } else {
                    cntX = 1;
                }
            }

            // 열 검사
            int cntY = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    cntY++;
                    maxLen = Math.max(cntY, maxLen);
                } else {
                    cntY = 1;
                }
            }
        }
    }
}
