package com.baekjoon.p5014;

import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        F = Integer.valueOf(st.nextToken());
        S = Integer.valueOf(st.nextToken());
        G = Integer.valueOf(st.nextToken());
        U = Integer.valueOf(st.nextToken());
        D = Integer.valueOf(st.nextToken());

        visited = new boolean[F + 1];

        bfs();

        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result - 1);
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        int count = 0;

        q.add(S);
        visited[S] = true;

        while (!q.isEmpty()) {
            count++;
            int length = q.size();

            for (int i = 0; i < length; i++) {
                int temp = q.poll();

                if (temp == G) {
                    result = count;
                    return;
                }

                if (temp - D > 0 && !visited[temp - D]) {
                    q.add(temp - D);
                    visited[temp - D] = true;
                }
                if (temp + U <= F && !visited[temp + U]) {
                    q.add(temp + U);
                    visited[temp + U] = true;
                }
            }
        }
    }
}