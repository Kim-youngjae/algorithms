package com.baekjoon.p2891;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;

    private static int[] team;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.valueOf(st.nextToken());

        team = new int[N];

        for (int i = 0; i < team.length; i++) {
            team[i] = 1;
        }

        st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            team[Integer.valueOf(st.nextToken()) - 1] -= 1;
        }

        st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            team[Integer.valueOf(st.nextToken()) - 1] += 1;
        }

        // 출전 팀 -> N 개
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                checkRight(i);
            } else if (i == N - 1) {
                checkLeft(i);
            } else {
                checkLeft(i);
                checkRight(i);
            }
        }

        int count = 0;

        for (int i : team) {
            if (i == 0) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static void checkLeft(int i) {
        if (team[i] > 1 && team[i - 1] == 0) {
            team[i - 1] += 1;
            team[i] -= 1;
        }
    }

    private static void checkRight(int i) {
        if (team[i] > 1 && team[i + 1] == 0) {
            team[i + 1] += 1;
            team[i] -= 1;
        }
    }
}
