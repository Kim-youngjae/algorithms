package com.baekjoon.p9375;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            Map<String, Integer> map = new HashMap<>();

            int N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                sc.next();

                String type = sc.next();

                if (map.containsKey(type)) {
                    map.put(type, map.get(type) + 1); // 이미 값이 있는 경우 종류 개수를 증가
                } else {
                    map.put(type, 1);
                }
            }

            int result = 1;

            for (int val : map.values()) {
                result *= (val + 1);
            }

            sb.append((result - 1) + "\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
