package com.baekjoon.p2961;

import java.io.*;
import java.util.*;

public class Main {
    static int N, min;
    static int[] S;
    static int[] B;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        S = new int[N];
        B = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        dfs(1, 0, 0, 0);
        System.out.println(min);
    }

    static void dfs(int s, int b, int depth, int selected) {
        if (depth == N) {
            /**
             * 하나 이상이 선택되어 있어야 하므로 selected가 1이상인지 확인
             * 쓴맛과 신맛의 차이 값을 갱신
             */
            if (selected != 0 && Math.abs(s - b) < min) {
                min = Math.abs(s - b);
            }
            return;
        }

        dfs(s * S[depth], b + B[depth], depth + 1, selected + 1); // 선택한 경우
        dfs(s, b, depth + 1, selected); // 선택하지 않은 경우
    }
}
