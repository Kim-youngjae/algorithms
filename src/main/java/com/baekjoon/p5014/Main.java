package com.baekjoon.p5014;

import java.io.*;
import java.util.*;

public class Main {
    static int[] floor;
    // static boolean[] visit;
    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        floor = new int[F + 1];
        // visit = new boolean[F + 1];

        bfs(S);

    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        floor[start] = 1;
        // visit[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            // visit[cur] = true;

            if (cur == G) {
                System.out.println(floor[G] - 1);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next;

                if (i == 0)
                    next = cur + U;
                else
                    next = cur - D;

                if (next < 1 || next > F) {
                    continue;
                }

                if (next == cur) {
                    continue;
                }

                if (floor[next] == 0) { // && !visit[next]
                    q.add(next);
                    floor[next] = floor[cur] + 1;
                }
            }
        }

        // if (!visit[G]) {
        if (floor[G] == 0) {
            System.out.println("use the stairs");
        }
    }
}