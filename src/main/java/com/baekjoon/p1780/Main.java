package com.baekjoon.p1780;

import java.io.*;
import java.util.*;

public class Main {
    static int A; // -1
    static int B; // 0
    static int C; // 1
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        br.close();
    }

    private static void partition(int r, int c, int size) {

        if (checkSet(r, c, size)) {
            if (arr[r][c] == -1) {
                A++;
            } else if (arr[r][c] == 0) {
                B++;
            } else {
                C++;
            }

            return;
        }

        // 다른 종이가 있으면 9개로 분할
        int newSize = size / 3;

        partition(r, c, newSize);
        partition(r, c + newSize, newSize);
        partition(r, c + 2 * newSize, newSize);

        partition(r + newSize, c, newSize);
        partition(r + newSize, c + newSize, newSize);
        partition(r + newSize, c + 2 * newSize, newSize);

        partition(r + 2 * newSize, c, newSize);
        partition(r + 2 * newSize, c + newSize, newSize);
        partition(r + 2 * newSize, c + 2 * newSize, newSize);
    }

    private static boolean checkSet(int r, int c, int size) {
        int std = arr[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (std != arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
