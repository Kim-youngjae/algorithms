package com.baekjoon.p1920;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        Map<Integer, Integer> mapA = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mapA.put(sc.nextInt(), 0);
        }

        int m = sc.nextInt();
        int[] arrB = new int[m];

        for (int i = 0; i < m; i++) {
            arrB[i] = sc.nextInt();
        }

        for (int i : arrB) {
            if (mapA.containsKey(i)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
        sc.close();
    }
}
