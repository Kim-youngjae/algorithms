package com.baekjoon.p2096;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] seq;
    static int[][] dpMax;
    static int[][] dpMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        seq = new int[N + 1][3];
        dpMax = new int[N + 1][3];
        dpMin = new int[N + 1][3];

        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            seq[i][0] = Integer.parseInt(st.nextToken());
            seq[i][1] = Integer.parseInt(st.nextToken());
            seq[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dpMax[i][0] = Math.max(seq[i][0] + dpMax[i - 1][0], seq[i][0] + dpMax[i - 1][1]);
            dpMax[i][1] = Math.max(seq[i][1] + dpMax[i - 1][0],
                    Math.max(seq[i][1] + dpMax[i - 1][1], seq[i][1] + dpMax[i - 1][2]));
            dpMax[i][2] = Math.max(seq[i][2] + dpMax[i - 1][1], seq[i][2] + dpMax[i - 1][2]);

            dpMin[i][0] = Math.min(seq[i][0] + dpMin[i - 1][0], seq[i][0] + dpMin[i - 1][1]);
            dpMin[i][1] = Math.min(seq[i][1] + dpMin[i - 1][0],
                    Math.min(seq[i][1] + dpMin[i - 1][1], seq[i][1] + dpMin[i - 1][2]));
            dpMin[i][2] = Math.min(seq[i][2] + dpMin[i - 1][1], seq[i][2] + dpMin[i - 1][2]);
        }

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            max = Math.max(max, dpMax[N][i]);
            min = Math.min(min, dpMin[N][i]);
        }

        sb.append(max + " " + min);
        System.out.println(sb);
    }
}
