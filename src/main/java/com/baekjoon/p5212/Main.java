package com.baekjoon.p5212;

import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dr = { 1, 0, -1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int sr = R, er = 0, sc = C, ec = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'X') {
                    int cnt = 0;

                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                            cnt++;
                        } else {
                            // 범위 안에 있는 경우
                            if (map[nr][nc] == '.') {
                                cnt++;
                            }
                        }

                    }

                    if (cnt >= 3) {
                        map[i][j] = '-';
                    }
                }

                if (map[i][j] == 'X') {
                    // 줄어든 지도 좌표 갱신
                    sr = Math.min(sr, i);
                    er = Math.max(er, i);
                    sc = Math.min(sc, j);
                    ec = Math.max(ec, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = sr; i <= er; i++) {
            for (int j = sc; j <= ec; j++) {
                if (map[i][j] == 'X') {
                    sb.append(map[i][j]);
                } else {
                    sb.append('.');
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
