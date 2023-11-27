package com.baekjoon.p7795;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        int[] A;
        Map<Integer, Integer> B = new HashMap<>();

        for (int t = 1; t <= T; t++) {

            int N = sc.nextInt();
            int M = sc.nextInt();

            A = new int[N];
            B.clear();

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++) {
                B.put(sc.nextInt(), 0);
            }

            List<Integer> keys = new ArrayList<>(B.keySet());

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < keys.size(); j++) {
                    int key = keys.get(j);
                    if (A[i] > key) {
                        B.replace(key, B.get(key) + 1);
                    }
                }
            }

            int sum = 0; // 순서 쌍 개수

            for (int i : keys) {
                sum += B.get(i);
            }

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}
