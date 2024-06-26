package com.baekjoon.p2559;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] seq = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, l = 0, r = K, max = 0;

        for (int i = l; i < r; i++) {
            sum += seq[i];
        }

        max = sum;

        while (r < N) {
            if (max < sum) {
                max = sum;
            }
            sum += seq[r++] - seq[l++];
        }

        System.out.println(max);

    }
}
