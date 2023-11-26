package com.baekjoon.p2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new LinkedHashMap<>(); // 2: 3, 1: 2

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());

            if (map.containsKey(key)) {
                map.replace(key, map.get(key) + 1);
            } else { // 키를 가지고 있지 않다면
                map.put(key, 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet()); // 2, 1

        // Collections.sort(list, new Comparator<Integer>() { // list가 클래스가 아니어서 람다식으로
        // 비교가 안되는 것 같음
        // @Override
        // public int compare(Integer a, Integer b) {
        // return Integer.compare(map.get(b), map.get(a));
        // }
        // });

        Collections.sort(list, (a, b) -> {
            return Integer.compare(map.get(b), map.get(a));
        });

        for (int k : list) {
            for (int i = 0; i < map.get(k); i++) {
                sb.append(k).append(" ");
            }
        }

        System.out.println(sb);
    }
}
