package com.baekjoon.p1325;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max, cnt;
    static int[] com;
    static List<List<Integer>> rel = new ArrayList<>();
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        com = new int[N + 1];
        for (int i = 0; i <= N; i++) { // 배열 초기화 1~N
            rel.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) { // 신뢰관계 입력받기
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            rel.get(a).add(b);
        }

        for (int i = 1; i <= N; i++) {
            v = new boolean[N + 1];
            dfs(i);
        }

        for (int cnt : com) {
            max = Math.max(cnt, max);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (com[i] == max) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int idx) {
        v[idx] = true;
        for (int i : rel.get(idx)) {
            if (!v[i]) {
                com[i]++;
                dfs(i);
            }
        }

    }
}
