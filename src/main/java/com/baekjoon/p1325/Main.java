package com.baekjoon.p1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] arr;
    static boolean v[];
    static int max;
    static int cntArr[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cntArr = new int[N + 1];

        // 신뢰 관계 입력
        arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            arr[i] = new ArrayList<Integer>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b); // a가 b를 신뢰, a는 b에게 해킹 당할 수 있음
        }

        // 1번부터 N번까지 search
        for (int i = 1; i <= N; i++) {
            v = new boolean[N + 1];
            BFS(i);
        }

        // 해킹할 수 있는 최댓값 찾기
        for (int i = 1; i <= N; i++) {
            if (max < cntArr[i])
                max = cntArr[i];
        }

        // 최댓값인 컴퓨터 출력
        for (int i = 1; i <= N; i++)
            if (max == cntArr[i])
                System.out.print(i + " ");
    }

    static void BFS(int start) {
        Queue<Integer> que = new ArrayDeque<Integer>();

        que.add(start);
        v[start] = true;

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i : arr[now]) {
                if (!v[i]) {
                    cntArr[i]++; // i가 해킹할 수 있는 숫자 증가
                    v[i] = true;
                    que.add(i);
                }
            }
        }
    }
}
