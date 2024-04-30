package com.baekjoon.p1389;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans, min;
    static List<List<Integer>> list;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            v = new boolean[N + 1];
            bfs(i);
        }

        System.out.println(ans);
    }

    static void bfs(int start) {
        Queue<Info> q = new ArrayDeque<>();

        q.add(new Info(start, 0));
        v[start] = true;
        int kevinBacon = 0;

        while (!q.isEmpty()) {
            Info temp = q.poll();

            for (int next : list.get(temp.index)) {
                if (!v[next]) {
                    kevinBacon += temp.count + 1;
                    v[next] = true;
                    q.add(new Info(next, temp.count + 1));
                }
            }
        }

        if (kevinBacon < min) {
            min = kevinBacon;
            ans = start;
        }
    }
}

class Info {
    int index;
    int count;

    Info(int index, int count) {
        this.index = index;
        this.count = count;
    }
}
