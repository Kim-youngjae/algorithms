package com.baekjoon.p2468;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] node;
    static boolean[][] visited;
    static int rainAmount = 0;
    static int safeZone = 0;
    static int totalCount = 0;

    static int[] dirRow = { 1, 0, -1, 0 };
    static int[] dirCol = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.valueOf(br.readLine());

        node = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < n; j++) {
                node[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        while (rainAmount < n) {
            // 비의 양을 계속 증가 시키면서 갯수를 세어야 함
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (node[i][j] > rainAmount && !visited[i][j]) {
                        safeZone++; // 갈 수 있는 곳을 만나면 안전영역으로 추가
                        bfs(i, j);
                    }
                }
            }

            if (totalCount < safeZone) {
                totalCount = safeZone;
                safeZone = 0;
                visited = new boolean[n][n]; // 방문 노드 초기화
            }
            rainAmount++;
        }

        System.out.println(totalCount);

    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { r, c });
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();

            int cr = temp[0];
            int cc = temp[1];

            for (int i = 0; i < 4; i++) {
                int mr = cr + dirRow[i];
                int mc = cc + dirRow[i];

                if (mc >= 0 && mc < n && mc > rainAmount && mr >= 0 && mr < n && mr > rainAmount) {
                    q.add(new int[] { mr, mc });
                    visited[mr][mc] = true;
                }
            }
        }
    }

}
