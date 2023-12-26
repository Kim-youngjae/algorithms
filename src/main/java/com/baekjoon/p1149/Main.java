package com.baekjoon.p1149;

import java.io.*;
import java.util.*;

public class Main {

    static int RED = 0;
    static int GREEN = 1;
    static int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] house = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }

            house[i][RED] = Math.min(house[i - 1][GREEN], house[i - 1][BLUE]) + house[i][RED];
            house[i][GREEN] = Math.min(house[i - 1][RED], house[i - 1][BLUE]) + house[i][GREEN];
            house[i][BLUE] = Math.min(house[i - 1][RED], house[i - 1][GREEN]) + house[i][BLUE];
        }

        int result = Math.min(Math.min(house[N][RED], house[N][GREEN]), house[N][BLUE]);

        System.out.println(result);

    }
}
