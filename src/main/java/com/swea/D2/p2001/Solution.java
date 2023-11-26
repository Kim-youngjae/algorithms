package com.swea.D2.p2001;

import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static int[][] map;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            max = Integer.MIN_VALUE; // max 값 초기화

            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 초기화
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N - M + 1; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    int sum = 0;

                    for (int r = 0; r < M; r++) {
                        for (int c = 0; c < M; c++) {
                            sum += map[i + r][j + c];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }
}
