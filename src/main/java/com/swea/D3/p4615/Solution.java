package com.swea.D3.p4615;

// 재미있는 오셀로 게임
import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static int[][] map;

    static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            // 초기 돌 위치
            map[N / 2 - 1][N / 2 - 1] = 2;
            map[N / 2 - 1][N / 2] = 1;
            map[N / 2][N / 2 - 1] = 1;
            map[N / 2][N / 2] = 2;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine()); // 돌 놓을 위치, 돌 색깔
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                int rock = Integer.parseInt(st.nextToken());

                checkAndSwap(r, c, rock);
            }

            int white = 0;
            int black = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {
                        black++;
                    } else {
                        white++;
                    }
                }
            }

            sb.append(black + " " + white + "\n");
        }

        System.out.println(sb);
    }

    static void checkAndSwap(int r, int c, int rock) {
        map[r][c] = rock;

        Queue<int[]> q = new LinkedList<>(); // 바꿀 돌을 저장할 큐

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            while (true) {
                // 빈칸이 나오거나 범위를 벗어나면 종료
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    break;
                } else if (map[nr][nc] != rock) { // 탐색할 위치의 돌 색깔이 다를 경우
                    q.add(new int[] { nr, nc });
                    // 돌색깔이 같으면 반복문 종료
                } else if (map[nr][nc] == rock) {
                    // 큐에 들어있는 색깔이 다른 모든 돌을 변경
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        map[now[0]][now[1]] = rock;
                    }
                } else {
                    break;
                }

                nr += dr[i];
                nc += dc[i];
            }

        }

    }
}
