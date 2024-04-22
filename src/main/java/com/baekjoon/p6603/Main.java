package com.baekjoon.p6603;

import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] s;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            s = new int[k];
            v = new boolean[k];

            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(s); // 정렬

            dfs(0, 0);

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int idx, int depth) {
        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if (v[i]) {
                    sb.append(s[i] + " ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < k; i++) {
            if (!v[i]) {
                v[i] = true;
                dfs(i, depth + 1);
                v[i] = false;
            }
        }
    }
}
