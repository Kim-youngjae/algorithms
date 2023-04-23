package com.baekjoon.p2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int maxRain = Integer.MIN_VALUE; // 가장 많은 비의 양을 저장할 변수
    static int minRain = Integer.MAX_VALUE; // 가장 적은 비의 양을 저장할 변수
    static int N;
    static int[][] region;
    static boolean[][] visited;
    static int[] safeZone; // 비의 양에 따른 안전영역의 갯수
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        region = new int[N][N];

        // 지역 초기화 및 최대, 최소 비 높이 설정
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken()); // 그 지역의 높이

                if (height >= maxRain) { // 최대값보다 크면 최대 값으로 저장
                    maxRain = height;
                } else if (height <= minRain) {
                    minRain = height; // 해당 값을 가장 비가 작게 올 때의 값으로 저장
                }

                region[i][j] = height;
            }
        }

        safeZone = new int[maxRain + 1];

        for (int rain = 0; rain <= maxRain; rain++) {
            visited = new boolean[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (region[j][k] > rain && !visited[j][k]) {
                        bfs(j, k, rain);
                        safeZone[rain]++;
                    }
                }
            }
        }

        int maxSafeZoneCnt = Integer.MIN_VALUE;

        for (int i = 0; i < safeZone.length; i++) {
            if (maxSafeZoneCnt <= safeZone[i]) {
                maxSafeZoneCnt = safeZone[i];
            }
        }

        System.out.println(maxSafeZoneCnt);
    }

    private static void bfs(int r, int c, int rain) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cordi = q.poll();

            int currRow = cordi[0];
            int currCol = cordi[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + dr[i];
                int nextCol = currCol + dc[i];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < N) {
                    if (region[nextRow][nextCol] > rain && !visited[nextRow][nextCol]) {
                        q.add(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
    }
}
