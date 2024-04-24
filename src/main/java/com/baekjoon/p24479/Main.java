package com.baekjoon.p24479;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<List<Integer>> m = new ArrayList<>();
    static int[] v;
    static StringBuilder sb = new StringBuilder();
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        v = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            m.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            m.get(r).add(c);
            m.get(c).add(r);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(m.get(i));
        }

        idx = 1;
        dfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(v[i] + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start) {
        v[start] = idx;

        for (int i = 0; i < m.get(start).size(); i++) {
            if (v[m.get(start).get(i)] == 0) {
                idx++;
                dfs(m.get(start).get(i));
            }
        }
    }
}
