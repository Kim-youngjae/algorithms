package com.baekjoon.p9372;

import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] v;
    static int n, m;
    static int ans = Integer.MAX_VALUE - 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            // 그래프 초기화
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            // 왕복 비행기 정보 배열에 넣어주기
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            for (int i = 1; i <= n; i++) {
                dfs(i, 0);
            }
        }
    }

    static void dfs(int start, int cnt) {
        if (checkVisit()) {
            ans = Math.min(ans, cnt);
            return;
        }
    }

    // 모든 국가를 방문했는지 체크하는 메서드
    static boolean checkVisit() {

        for (int i = 1; i <= n; i++) {
            if (!v[i]) {
                return false;
            }
        }

        return true;
    }
}
