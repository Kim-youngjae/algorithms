package com.thisiscodingtest.p375;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            int row = sc.nextInt();
            int col = sc.nextInt();
            int[][] map = new int[row][col];
            int[][] d = new int[row][col];

            for (int a = 0; a < row; a++) { // 금광 초기화
                for (int b = 0; b < col; b++) {
                    map[a][b] = sc.nextInt();
                }
            }

            for (int r = 0; r < row; r++) { // 행 첫 줄 초기화
                d[r][0] = map[r][0];
            }

            for (int c = 1; c < col; c++) { // 열
                for (int r = 0; r < row; r++) {
                    int up, mid, down;

                    if (r == 0) { // 첫 행이면
                        up = 0;
                    } else {
                        up = d[r - 1][c - 1];
                    }

                    mid = d[r][c - 1];

                    if (r == row - 1) { // 마지막 행이면
                        down = 0;
                    } else {
                        down = d[r + 1][c - 1];
                    }

                    d[r][c] = map[r][c] + Math.max(up, Math.max(mid, down)); // 해당 열의 금의 값과 그 전 금들중 최대값과 더한 값이 해당 금의 값
                }
            }

            int max_gold = 0;

            for (int r = 0; r < row; r++) {
                max_gold = Math.max(max_gold, d[r][col - 1]); // 가장 많은 금을 캔 행을 출력
            }

            System.out.println(max_gold);

        }
    }
}
