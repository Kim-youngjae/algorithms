package com.baekjoon.data_structure.p24511;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 자료구조 타입
        int[] types = new int[N];

        for (int i = 0; i < N; i++) {
            types[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> qs = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(st.nextToken());
            if (types[i] == 0) {
                qs.addLast(data);
            }
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int inputData = Integer.parseInt(st.nextToken());

            qs.addFirst(inputData);
            sb.append(qs.pollLast()).append(" ");
        }

        System.out.print(sb.toString());
    }
}
