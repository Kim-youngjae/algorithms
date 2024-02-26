package com.baekjoon.p5427;

import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] map;
    static boolean[][] visit;

    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };

    static Queue<int[]> fire;
    static Queue<int[]> person;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visit = new boolean[h][w];
            person = new LinkedList<>();
            fire = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = str.charAt(j);
                    if (c == '*') {
                        fire.add(new int[] { i, j });
                    } else if (c == '@') {
                        person.add(new int[] { i, j, 0 });
                    }

                    map[i][j] = c;
                }
            }

            int res = -1;

            escape: while (true) {
                burn();

                int size = person.size();
                for (int s = 0; s < size; s++) {
                    int[] p = person.poll();
                    res = canEscape(p[0], p[1], p[2]);
                    if (res != -1) {
                        break escape;
                    }
                }
                if (person.isEmpty()) {
                    break;
                }
            }

            if (res != -1) {
                sb.append(res + "\n");
            } else {
                sb.append("IMPOSSIBLE\n");
            }
        }

        System.out.println(sb);
    }

    private static int canEscape(int r, int c, int time) {

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= h || nc < 0 || nc >= w) {
                return time + 1;
            }

            if (map[nr][nc] == '.' && !visit[nr][nc]) {
                person.add(new int[] { nr, nc, time + 1 });
                map[nr][nc] = '@';
            }
        }
        return -1;
    }

    private static void burn() {
        int size = fire.size();

        for (int s = 0; s < size; s++) {
            int[] now = fire.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) {
                    continue;
                }

                if (map[nr][nc] == '.' || map[nr][nc] == '@') {
                    fire.add(new int[] { nr, nc });
                    map[nr][nc] = '*';
                }
            }
        }
    }
}