package com.baekjoon.p1916;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] a; // 각 노드 비용
    static int[] d; // 거리를 저장
    static boolean[] v; // 방문 노드
    static final int INF = 1_000_000_000;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        a = new int[N][N];
        d = new int[N];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = INF;
            }
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            a[r][c] = cost;

        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        dijkstra(start);

        System.out.println(d[end]);
    }

    static void dijkstra(int start) {
        // 거리 배열을 시작하는 노드의 거리 정보로 초기화
        for (int i = 0; i < N; i++) {
            d[i] = a[start][i];
        }

        v[start] = true; // 방문 처리

        for (int i = 0; i < N - 2; i++) {
            int current = getMinIndex(); // 비용이 가장 작은 인덱스를 반환
            v[current] = true;

            // 최소 비용 갱신하기
            for (int j = 0; j < N; j++) {
                // 아직 방문하지 않은 (최소 비용이 갱신되지 않은) 노드들을 갱신 해주기
                if (!v[j]) {
                    if (d[current] + a[current][j] < d[j]) {
                        d[j] = d[current] + a[current][j];
                    }
                }
            }
        }
    }

    static int getMinIndex() {
        int min = INF;
        int index = 0;

        for (int i = 0; i < N; i++) {
            if (d[i] < min && !v[i]) {
                min = d[i];
                index = i;
            }
        }
        return index;
    }
}
