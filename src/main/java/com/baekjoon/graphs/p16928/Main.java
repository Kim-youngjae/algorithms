package com.baekjoon.graphs.p16928;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사다리 수
        M = Integer.parseInt(st.nextToken()); // 뱀의 수

        map = new int[101];

        for (int i = 1; i <= 100; i++) {
            map[i] = i;
        }

        // 사다리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from] = to;
        }

        // 뱀
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from] = to;
        }

        bfs();

    }

    static void bfs() {
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        int[] dist = new int[101];

        Q.add(1);

        while (true) {
            int now = Q.poll();

            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                if (next > 100)
                    continue;
                if (dist[map[next]] == 0) {
                    Q.add(map[next]);
                    dist[map[next]] = dist[now] + 1;
                }

                if (map[next] == 100) {
                    System.out.println(dist[100]);
                    return;
                }
            }
        }
    }
}
