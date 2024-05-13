package com.baekjoon.p10971;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] v;
    static int[][] m;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        m = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            v = new boolean[N]; // 방문 배열
            v[i] = true;
            TSP(i, i, 0);
        }

        System.out.println(min);
    }

    static void TSP(int start, int now, int cost) {

        if (allVisited()) {
            if (m[now][start] != 0) {
                min = Math.min(min, cost + m[now][start]);
            }
            return;
        }

        for (int next = 1; next < N; next++) {
            if (!v[next] && m[now][next] != 0) { // 방문하지 않았거나 갈 수 있으면
                v[next] = true;
                TSP(start, next, cost + m[now][next]);
                v[next] = false;
            }
        }
    }

    static boolean allVisited() {
        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                return false;
            }
        }
        return true;
    }
}
