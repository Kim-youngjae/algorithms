package com.baekjoon.p11404;

import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 100001 * 99;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                } else {
                    map[i][j] = INF;
                }
            }
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 입력 받을 때도 여러 개가 있을 수 있으므로 최소값으로 갱신
            map[from][to] = Math.min(map[from][to], cost);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == INF) {
                    map[i][j] = 0;
                }

                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
