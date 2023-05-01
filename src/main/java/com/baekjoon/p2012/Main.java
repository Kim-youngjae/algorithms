package com.baekjoon.p2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] expectRanks = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            expectRanks[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expectRanks);

        long disSatisfaction = 0;

        for (int i = 1; i <= N; i++) {
            disSatisfaction += Math.abs(i - expectRanks[i]);
        }

        System.out.println(disSatisfaction);
    }
}
