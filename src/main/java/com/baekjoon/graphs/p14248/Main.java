package com.baekjoon.graphs.p14248;

import java.io.*;
import java.util.*;

public class Main {

    static int[] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        bfs(Integer.parseInt(br.readLine()) - 1);
    }

    static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] v = new boolean[N];
        int cnt = 1;

        q.add(start);
        v[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            int left = now - map[now]; // 왼쪽으로 이동
            int right = now + map[now]; // 오른쪽으로 이동

            if (left >= 0 && !v[left]) {
                q.add(left);
                v[left] = true;
                cnt++;
            }

            if (right < N && !v[right]) {
                q.add(right);
                v[right] = true;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
