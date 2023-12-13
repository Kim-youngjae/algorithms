package com.baekjoon.p14921;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] liquid = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N - 1;
        long minValue = Long.MAX_VALUE;

        int idx1 = 0;
        int idx2 = 0;

        while (start < end) {
            long sum = liquid[start] + liquid[end];

            if (minValue > Math.abs(sum)) {
                minValue = Math.abs(sum);
                idx1 = start;
                idx2 = end;
            }

            if (sum >= 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(liquid[idx1] + liquid[idx2]);
    }
}
