package com.baekjoon.p2847;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[] scores = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++ ) {
            scores[i] = Integer.valueOf(br.readLine());
        }

        for (int i = N - 1; i > 0; i--) {
            while(scores[i - 1] >= scores[i]) {
                scores[i - 1] -= 1;
                count++;
            }
        }

        System.out.println(count);
    }
}
