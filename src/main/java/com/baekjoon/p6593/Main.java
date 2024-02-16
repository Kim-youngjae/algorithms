package com.baekjoon.p6593;

import java.io.*;
import java.util.*;

public class Main {

    static int L, R, C, x;
    static char[][][] maze;
    static Position start;

    static int[] df = { 0, 0, 0, 0, -1, 1 };
    static int[] dr = { -1, 0, 1, 0, 0, 0 };
    static int[] dc = { 0, 1, 0, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            x = 0;
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            maze = new char[L][R][C];

            for (int l = 0; l < L; l++) {

                for (int r = 0; r < R; r++) {
                    String str = br.readLine();
                    for (int c = 0; c < C; c++) {
                        char p = str.charAt(c);
                        if (p == 'S') {
                            start = new Position(l, r, c, 0); // 시작지점 저장
                        }

                        maze[l][r][c] = p;
                    }
                }

                br.readLine(); // 개행 입력 받기
            }

            bfs(start);

            if (x == 0) {
                sb.append("Trapped!" + "\n");
            } else {
                sb.append("Escaped in " + x + " minute(s)." + "\n");
            }

        }

        System.out.println(sb);

    }

    private static void bfs(Position start) {
        Queue<Position> q = new LinkedList<>();

        q.add(start);

        while (!q.isEmpty()) {
            Position t = q.poll();

            for (int i = 0; i < 6; i++) {
                int nl = t.l + df[i];
                int nr = t.r + dr[i];
                int nc = t.c + dc[i];

                if (nl < 0 || nl >= L || nr < 0 || nr >= R || nc < 0 || nc >= C) {
                    continue;
                }

                if (maze[nl][nr][nc] == '.') {
                    maze[nl][nr][nc] = 'C';
                    q.add(new Position(nl, nr, nc, t.min + 1));
                } else if (maze[nl][nr][nc] == 'E') {
                    x = t.min + 1;
                    break;
                }
            }
        }
    }
}

class Position {
    int l;
    int r;
    int c;
    int min;

    Position(int l, int r, int c, int min) {
        this.l = l;
        this.r = r;
        this.c = c;
        this.min = min;
    }
}