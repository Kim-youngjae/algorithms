package com.swea.D3.p2817;

import java.io.*;
import java.util.*;

public class Solution {
    static int n, k, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            res = 0;
            arr = new int[n];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append(res + "\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int i, int sum) {
        if (sum == k) {
            res++;
            return;
        } else if (sum > k || i == n) {
            return;
        }

        dfs(i + 1, sum + arr[i]);
        dfs(i + 1, sum);
    }
}
