package com.baekjoon.p18870;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>(N);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int key = sc.nextInt();

            list.add(key);
            map.put(key, 0);
        }

        List<Integer> uniqueValues = new ArrayList<>(map.keySet());
        Collections.sort(uniqueValues);

        for (int i = 0; i < uniqueValues.size(); i++) {
            map.put(uniqueValues.get(i), i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i : list) {
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb);
        sc.close();
    }
}
