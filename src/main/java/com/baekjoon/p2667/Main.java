package com.baekjoon.p2667;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[][] node = new int[25][25];
    static boolean[][] visited = new boolean[25][25];

    static int[] dirR = new int[] { 1, 0, -1, 0 };
    static int[] dirC = new int[] { 0, 1, 0, -1 };

    static int houseCount = 0; // 건물 개수
    static int[] range = new int[25 * 25]; // 평수
    static int n;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지도의 크기
        n = Integer.valueOf(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < n; j++) {
                node[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (node[i][j] == 1 && !visited[i][j]) {
                    houseCount++;
                    bfs(i, j);
                }
            }
        }

        Arrays.sort(range);

        System.out.println(houseCount);

        for (int i : range) {
            if (i != 0) {
                System.out.println(i + 1);
            }
        }

    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { r, c }); // 노드 큐에 넣기
        visited[r][c] = true; // 방문 처리

        while (!q.isEmpty()) {
            int[] target = q.poll();

            int cr = target[0]; // current
            int cc = target[1];

            for (int i = 0; i < 4; i++) {
                int mr = cr + dirR[i];
                int mc = cc + dirC[i];

                if (mr >= 0 && mr < n && mc >= 0 && mc < n) {
                    if (node[mr][mc] == 1 && !visited[mr][mc]) {
                        q.add(new int[] { mr, mc });
                        visited[mr][mc] = true;
                        range[houseCount]++;
                    }
                }
            }
        }
    }
}