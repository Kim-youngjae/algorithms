package com.baekjoon.p9461;

import java.io.*;

public class Main {
    static long[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        P = new long[101];

        P[1] = P[2] = P[3] = 1;

        for (int i = 4; i <= 100; i++) {
            P[i] = P[i - 3] + P[i - 2];
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(P[N] + "\n");
        }

        System.out.println(sb);
    }
}
