package com.baekjoon.p2630;

import java.io.*;
import java.util.*;

public class Main {

    static int N, WHITE, BLUE;
    static int[][] paper;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        division(0, 0, N);

        System.out.println(WHITE);
        System.out.println(BLUE);

    }

    static void division(int r, int c, int size) {

        if (colorCheck(r, c, size)) {
            if (paper[r][c] == 0) {
                WHITE++;
            }
            if (paper[r][c] == 1) {
                BLUE++;
            }
            return;
        }

        int newSize = size / 2;

        division(r, c, newSize); // 1사분면
        division(r, c + newSize, newSize); // 2사분면
        division(r + newSize, c, newSize); // 3사분면
        division(r + newSize, c + newSize, newSize); // 4사분면
    }

    static boolean colorCheck(int r, int c, int size) {
        int std = paper[r][c]; // 기준 색깔

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (std != paper[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
