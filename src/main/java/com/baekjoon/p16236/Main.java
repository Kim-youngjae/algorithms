package com.baekjoon.p16236;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    static class DistComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[2] == o2[2]) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }

            return Integer.compare(o1[2], o2[2]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int[] now = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    // 상어 위치
                    now = new int[] { i, j };
                    map[i][j] = 0;
                }
            }
        }

        int sharkSize = 2;
        int eat = 0;
        int time = 0;

        while (true) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(new DistComparator());
            boolean[][] v = new boolean[N][N];

            pq.add(new int[] { now[0], now[1], 0 });
            v[now[0]][now[1]] = true;

            boolean momCall = false; // 엄마상어 호출
            while (!pq.isEmpty()) {
                now = pq.poll(); // 상어의 위치

                // 상어가 물고기를 먹을 수 있는 경우
                if (map[now[0]][now[1]] != 0 && map[now[0]][now[1]] < sharkSize) {
                    map[now[0]][now[1]] = 0;
                    eat++;
                    time += now[2];
                    momCall = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = now[0] + dr[i];
                    int nc = now[1] + dc[i];

                    if (nr >= 0 && nc >= 0 && nr < N && nc < N && !v[nr][nc] && map[nr][nc] <= sharkSize) {
                        pq.add(new int[] { nr, nc, now[2] + 1 });
                        v[nr][nc] = true;
                    }
                }
            }

            if (!momCall) {
                break;
            }

            if (eat == sharkSize) {
                sharkSize++;
                eat = 0;
            }
        }

        System.out.println(time);
    }
}