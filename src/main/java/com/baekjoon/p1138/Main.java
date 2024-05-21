package com.baekjoon.p1138;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        ArrayList<Integer> height = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            height.add(arr[i], i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : height) {
            sb.append(i + " ");
        }

        // 다른 풀이
        // int[] ans = new int[N];
        // for (int i = 0; i < N; i++) {
        // int cnt = 0;

        // for (int j = 0; j < N; j++) {
        // if (ans[j] == -1 && cnt < arr[i]) {
        // cnt++;
        // } else if (ans[j] == -1 && cnt == arr[i]) {
        // ans[j] = i + 1;
        // break;
        // }
        // }

        // }

        System.out.print(sb);
    }
}
