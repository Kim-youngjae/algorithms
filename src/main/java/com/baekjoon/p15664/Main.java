package com.baekjoon.p15664;

import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, res;
    static boolean[] v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        res = new int[M];
        dfs(0, 0);
        sc.close();
    }

    static void dfs(int from, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }

        int before = -1;
        for (int i = from; i < N; i++) { // from 부터 시작해서 뽑음
            int now = arr[i];
            if (before == now || v[i]) { // 이전에 뽑았던 수이거나 한번 고른 수열이면 중복 수열이 되므로 넘어감
                continue;
            } else {
                v[i] = true;
                before = now; // 현재 수열을 이전에 뽑았던 수로 갱신
                res[depth] = arr[i];
                dfs(from + 1, depth + 1);
                v[i] = false;
            }
        }
    }
}
