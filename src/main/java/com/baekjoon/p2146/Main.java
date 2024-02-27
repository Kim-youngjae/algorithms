package com.baekjoon.p2146;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] v;
    static Queue<int[]> q;

    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        v = new boolean[N][N];
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 구분
        islandCount();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 대륙이면 방문?
                if (map[i][j] > 0) {
                    v = new boolean[N][N];

                    int res = bridge(i, j); // 다리 길이 계산

                    if (res != -1) {
                        min = Math.min(min, res);
                    } else {
                        continue; // 다리 게산이 안되면 갱신 안하고 넘어감
                    }
                }
            }
        }
        System.out.println(min);
    }

    private static int bridge(int r, int c) {
        q = new LinkedList<>();

        int island = map[r][c]; // 현재 대륙 정보
        v[r][c] = true; // 방문 처리
        q.add(new int[] { r, c, 0 });

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (map[now[0]][now[1]] != island && map[now[0]][now[1]] != 0) { // 다른 대륙이면
                return now[2] - 1;
            }
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) { // 범위를 벗어나면
                    continue;
                }

                if (v[nr][nc] || map[nr][nc] == island) { // 방문 했거나 같은 대륙이면
                    continue;
                }

                v[nr][nc] = true;
                q.add(new int[] { nr, nc, now[2] + 1 });

            }

        }

        return -1; // 더이상 방문할 배열이 없으면 종료
    }

    private static void islandCount() {
        int idx = 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !v[i][j]) {
                    q.add(new int[] { i, j });
                    v[i][j] = true;
                    map[i][j] = idx;

                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nr = now[0] + dr[k];
                            int nc = now[1] + dc[k];

                            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                                continue;
                            }
                            if (map[nr][nc] == 1 && !v[nr][nc]) {
                                v[nr][nc] = true;
                                map[nr][nc] = idx;
                                q.add(new int[] { nr, nc });
                            }
                        }
                    }
                    idx++;
                }
            }
        }
    }
}
