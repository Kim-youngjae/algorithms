package com.baekjoon.p13305;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] city = new long[N];
        long[] dist = new long[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            city[i] = Long.parseLong(st.nextToken());
        }

        long curCost = city[0];
        long totalCost = 0;

        for (int i = 0; i < N - 1; i++) {
            if (curCost > city[i]) {
                curCost = city[i];
            }
            totalCost += curCost * dist[i];
        }

        System.out.println(totalCost);
    }
}
