package com.baekjoon.p11060;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] v;

    static class Node {
        int idx;
        int cnt;

        Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bfs(0);
    }

    static void bfs(int start) {
        Queue<Node> q = new ArrayDeque<>();
        v = new boolean[N];

        v[start] = true;
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.idx == N - 1) {
                System.out.println(now.cnt);
                return;
            }

            for (int i = 1; i <= arr[now.idx]; i++) {
                int nextIdx = now.idx + i;

                if (nextIdx < N && !v[nextIdx]) {
                    v[nextIdx] = true;
                    q.add(new Node(nextIdx, now.cnt + 1));
                }
            }
        }

        System.out.println(-1);
    }
}