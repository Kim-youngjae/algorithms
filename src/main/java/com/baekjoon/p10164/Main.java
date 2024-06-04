package com.baekjoon.p10164;

import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        // 동그라미 위치
        int r = (K - 1) / M;
        int c = (K - 1) % M;

        int ans = 0;
        if (K == 0) {
            ans = routing(N - 1, M - 1); // 첫 지점에서 끝 점까지 경로 찾기
        } else {
            int route1 = routing(r, c);
            int route2 = routing(N - r - 1, M - c - 1);

            /**
             * 경우의 수이기 떄문에
             * 처음 동그라미 친 부분으로 가능 경우의 수 * 동그라미 친 부분 -> 마지막까지 가는 경우의 수
             */
            ans = route1 * route2;
        }

        System.out.println(ans);
        sc.close();
    }

    static int routing(int r, int c) {
        ++r;
        ++c;
        int[] dr = { 0, 1 };
        int[] dc = { 1, 0 };
        int[][] dp = new int[r][c];

        dp[0][0] = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < 2; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (nr >= r || nc >= c) {
                        continue;
                    }

                    dp[nr][nc] += dp[i][j];
                }
            }
        }

        return dp[r - 1][c - 1];
    }
}
