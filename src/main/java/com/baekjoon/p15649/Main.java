package com.baekjoon.p15649;

import java.util.*;

public class Main {
    static int n, m;
    static int[] arr, selected;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n]; // 뽑을 배열
        visit = new boolean[n];
        selected = new int[m];

        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        pop(0);

        System.out.println(sb);
        sc.close();
    }

    private static void pop(int cnt) {
        if (cnt == m) {
            for (int i : selected) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                selected[cnt] = i + 1;
                pop(cnt + 1);
                visit[i] = false;
            }
        }
    }
}