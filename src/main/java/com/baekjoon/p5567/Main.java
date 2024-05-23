package com.baekjoon.p5567;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static boolean[] v;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        v = new boolean[N + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        // dfs(1, 0);
        bfs(1);
        for (int i = 2; i < v.length; i++) {
            if (v[i]) {
                ans++;
            }
        }
        System.out.print(ans);
    }

    static void dfs(int start, int cnt) {
        if (cnt == 2) {
            return;
        }

        for (int i = 0; i < list.get(start).size(); i++) {
            int friend = list.get(start).get(i);

            v[friend] = true;
            dfs(friend, cnt + 1);
        }
    }

    static void bfs(int start) {
        Queue<int[]> q = new ArrayDeque<>();

        v[start] = true;
        q.add(new int[] { start, 0 });

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int currentNode = now[0];
            int currentDepth = now[1];

            if (currentDepth >= 2) {
                continue;
            }

            for (int i : list.get(currentNode)) {
                if (!v[i]) {
                    v[i] = true;
                    q.add(new int[] { i, currentDepth + 1 });
                }
            }
        }
    }
}
