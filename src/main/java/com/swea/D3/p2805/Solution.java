package com.swea.D3.p2805;

import java.io.*;

public class Solution {
    static int n, mid;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            n = Integer.parseInt(br.readLine());

            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();

                for (int j = 0; j < n; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            int start = n / 2;
            int end = n / 2;
            mid = n / 2;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = start; j <= end; j++) {
                    sum += map[i][j];
                }

                if (i < mid) {
                    start--;
                    end++;
                } else {
                    start++;
                    end--;
                }
            }

            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }
}
