package com.baekjoon.p16234;

import java.io.*;
import java.util.*;

public class Main {

    static int N, L, R, day;
    static int[][] map;
    static boolean[][] v;
    static LinkedList<int[]> unions;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };
    static boolean isMove;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();

        System.out.println(day);
    }

    static void move() {

        while (true) {
            isMove = false;
            v = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!v[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            if (!isMove) {
                return;
            } else {
                day++; // 움직였다면 일 수를 카운트
            }
        }
    }

    // 연합이 가능한 국가들을 탐색
    static void bfs(int r, int c) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        unions = new LinkedList<>();

        v[r][c] = true;
        q.add(new int[] { r, c });
        unions.add(new int[] { r, c }); // 연합 국가들을 넣을 큐

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 && nc >= 0 && nr < N && nc < N && !v[nr][nc]
                        && Math.abs(map[now[0]][now[1]] - map[nr][nc]) >= L
                        && Math.abs(map[now[0]][now[1]] - map[nr][nc]) <= R) {
                    isMove = true;
                    v[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                    unions.add(new int[] { nr, nc });
                }
            }
        }

        // bfs 탐색이 끝나고 인구이동 하기
        if (unions.size() == 1) {
            // 사이즈가 1이면 연합한 국가가 없음
            return;
        } else {
            int size = unions.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                int[] pos = unions.get(i);
                sum += map[pos[0]][pos[1]]; // 연합 국가 인구수를 모두 더해주기
            }

            // 인구이동 계산 결과를 연합국에 반영
            int avg = sum / size;
            for (int i = 0; i < size; i++) {
                int[] pos = unions.poll();
                map[pos[0]][pos[1]] = avg;
            }
        }
    }
}
