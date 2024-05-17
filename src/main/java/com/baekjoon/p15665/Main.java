package com.baekjoon.p15665;

import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, res;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        res = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        dfs(0);
        System.out.print(sb);
        sc.close();

    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i : res) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;
        for (int i = 0; i < N; i++) {
            int now = arr[i];
            if (before == now) {
                continue;
            } else { // 중복되는 수열을 허용해야하기 때문에 방문 체크를 빼주어야 했다.
                before = now;
                res[depth] = arr[i];
                dfs(depth + 1);
            }
        }
    }
}
