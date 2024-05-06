package com.swea.D3.p1215;

import java.io.*;

public class Solution {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            sb.append("#").append(t).append(" ");

            int size = Integer.parseInt(br.readLine());

            map = new char[8][8];

            for (int i = 0; i < 8; i++) {
                String str = br.readLine();
                for (int j = 0; j < 8; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            int count = 0;

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length - size + 1; j++) {
                    boolean flag = true;

                    // 가로 회문 검사
                    for (int k = 0; k < size / 2; k++) {
                        if (map[i][j + k] != map[i][j + size - k - 1]) {
                            flag = false;
                        }
                    }

                    if (flag) {
                        count++;
                    }

                    flag = true;

                    // 세로 회문 검사
                    for (int k = 0; k < size / 2; k++) {
                        if (map[j + k][i] != map[j + size - k - 1][i]) {
                            flag = false;
                        }
                    }

                    if (flag) {
                        count++;
                    }

                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}