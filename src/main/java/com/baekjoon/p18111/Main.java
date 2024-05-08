package com.baekjoon.p18111;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, B, min, max, minTime, maxHeight;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        a = new int[N][M];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        minTime = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (a[i][j] > max)
                    max = a[i][j];
                if (a[i][j] < min)
                    min = a[i][j];
            }
        }

        for (int std = min; std <= max; std++) {

            int time = 0;
            int inven = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (std < a[i][j]) { // 기준 높이 보다 현재 높이가 더 높으면 제거하기
                        time += (a[i][j] - std) * 2;
                        inven += a[i][j] - std;
                    } else { // 기준 높이가 현재 높이 보다 더 놓으면 쌓기
                        time += std - a[i][j];
                        inven -= std - a[i][j];
                    }
                }
            }

            if (inven < 0) {
                continue;
            }

            if (minTime >= time) {
                minTime = time;
                maxHeight = std;
            }
        }

        System.out.println(minTime + " " + maxHeight);

    }
}
