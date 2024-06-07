package com.baekjoon.p1058;

import java.io.*;
import java.util.*;

public class Main {
    static int N, max;
    static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            Queue<Integer> q = new ArrayDeque<>();

            boolean[] v = new boolean[N];

            v[i] = true;
            q.add(i);

            int depth = 0;
            int cnt = 0;

            while (depth < 2) {

                int size = q.size();
                for (int j = 0; j < size; j++) {
                    int now = q.poll();

                    for (int k = 0; k < N; k++) {
                        if (graph[now][k] == 'Y' && !v[k]) {
                            cnt++;
                            v[k] = true;
                            q.add(k);
                        }
                    }
                }

                depth++;

            }

            if (max < cnt) {
                max = cnt;
            }
        }

        System.out.println(max);
    }

    static void relation(int start) {
        Queue<Integer> q = new ArrayDeque<>();

        boolean[] v = new boolean[N];

        v[start] = true;
        q.add(start);

        int depth = 0;
        int cnt = 0;

        while (depth < 2) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();

                if (graph[now][i] == 'Y' && !v[i]) {
                    cnt++;
                    v[i] = true;
                    q.add(i);
                }
            }

            depth++;

        }

        if (max < cnt) {
            max = cnt;
        }

    }
}
