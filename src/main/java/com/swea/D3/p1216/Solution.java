package com.swea.D3.p1216;

import java.io.*;

public class Solution {
    static char[][] map = new char[100][100];
    static boolean[][] visit = new boolean[100][100];
    static final int n = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine());

            for (int i = 0; i < 100; i++) {
                String str = br.readLine();

                for (int j = 0; j < 100; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            for (int i = n; i >= 1; i--) {
                if (solve(i)) {
                    sb.append("#" + tc + " " + i + "\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    private static boolean solve(int size) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - size + 1; j++) {
                if (checkRow(i, j, size) || checkCol(i, j, size))
                    return true;
            }
        }

        return false;
    }

    private static boolean checkRow(int i, int j, int size) {
        for (int k = 0; k < size / 2; k++) {
            if (map[i][j + k] != map[i][j + size - k - 1])
                return false;
        }

        return true;
    }

    private static boolean checkCol(int i, int j, int size) {
        for (int k = 0; k < size / 2; k++) {
            if (map[j + k][i] != map[j + size - k - 1][i])
                return false;
        }

        return true;
    }
}
