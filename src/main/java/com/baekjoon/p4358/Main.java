package com.baekjoon.p4358;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();

        int total = 0;
        String name = "";
        while ((name = br.readLine()) != null) {
            map.put(name, map.getOrDefault(name, 0) + 1);
            total++;
        }

        List<String> list = new ArrayList<>();

        for (String tree : map.keySet()) {
            list.add(tree);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (String tree : list) {
            double ratio = (double) (map.get(tree) * 100.0) / total; // 소수점 구할 때는 항상 double로 형 변환 해주기
            sb.append(tree + " " + String.format("%.4f", ratio) + "\n");
        }

        System.out.println(sb);

    }
}
