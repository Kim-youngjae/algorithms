package com.baekjoon.p2156;

import java.io.*;

public class Main {
    static int N, max;
    static int[] a;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        a = new int[N];
        v = new boolean[N];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N - (N / 3); i++) {
            dfs(0, i);
        }

        System.out.println(max);
    }

    static void dfs(int cnt, int m) {
        if (cnt == m) {
            int chk = 0;

            if (m >= 3) {
                for (int i = 0; i < N; i++) {
                    if (v[i]) {
                        chk++;
                    } else {
                        chk = 0;
                    }
                    if (chk == 3) {
                        return;
                    }
                }
            }

            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (v[i]) {
                    sum += a[i];
                }
            }

            max = Math.max(max, sum);
            return;

        }

        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                dfs(cnt + 1, m);
                v[i] = false;
            }
        }
    }
}
