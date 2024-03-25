package com.baekjoon.p11660;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] matrix;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                matrix[i][j] += Integer.parseInt(st.nextToken()) + matrix[i][j - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int fromR = Integer.parseInt(st.nextToken());
            int fromC = Integer.parseInt(st.nextToken());
            int toR = Integer.parseInt(st.nextToken());
            int toC = Integer.parseInt(st.nextToken());
            int sum = 0;

            for (int r = fromR; r <= toR; r++) {
                sum += (matrix[r][toC] - matrix[r][fromC - 1]);
            }

            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }
}
