package com.baekjoon.p1992;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        partition(N, 0, 0);

        System.out.println(sb);
    }

    static void partition(int size, int r, int c) {

        // 만약 체크했을 때 모두 같은 숫자이면 그 숫자로 압축
        if (check(size, r, c)) {
            if (map[r][c] == '0') {
                sb.append("0");
            } else {
                sb.append("1");
            }
            return;
        }

        int newSize = size / 2;

        sb.append("(");
        partition(newSize, r, c);
        partition(newSize, r, c + newSize);
        partition(newSize, r + newSize, c);
        partition(newSize, r + newSize, c + newSize);
        sb.append(")");
    }

    static boolean check(int size, int r, int c) {
        char std = map[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (std != map[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
