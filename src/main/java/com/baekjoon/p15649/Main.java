package com.baekjoon.p15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new int[n];
        visit = new boolean[n];

        // 배열 초기화
        for (int i = 0; i < n; i++) {
            list[i] = i + 1;
        }

        int[] output = new int[n];

        permutation(list, output, visit, 0, m);

    }

    public static void permutation(int[] list, int[] output, boolean[] visit, int depth, int m) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.printf("%d ", output[i]);
            }
            System.out.println();
        }

        for (int i = 0; i < list.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                output[depth] = list[i];
                permutation(list, output, visit, depth + 1, m);
                visit[i] = false;
            }
        }
    }
}
