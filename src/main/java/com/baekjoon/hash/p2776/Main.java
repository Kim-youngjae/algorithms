package com.baekjoon.hash.p2776;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<Integer, Integer> note1 = new HashMap<>();

        for (int t = 0; t < T; t++) {
            note1.clear();

            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                note1.put(Integer.parseInt(st.nextToken()), 0);
            }

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                if (note1.containsKey(Integer.parseInt(st.nextToken()))) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        }

        System.out.println(sb.toString());

    }
}
