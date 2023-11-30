package com.swea.D2.p2005;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i + 1; j++) {
                    if (i == j || j == 0) {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = map[i - 1][j] + map[i - 1][j - 1];
                    }
                }
            }

            sb.append("#").append(t).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i + 1; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
        sc.close();
    }
}
