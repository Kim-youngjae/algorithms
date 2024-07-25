package com.baekjoon.sorting.p20920;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String val = br.readLine();

            if (val.length() < M) {
                continue;
            }

            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (Integer.compare(map.get(s1), map.get(s2)) != 0) {
                    return Integer.compare(map.get(s2), map.get(s1));
                }

                if (s1.length() != s2.length()) {
                    return s2.length() - s1.length();
                }

                return s1.compareTo(s2);
            }
        });

        for (

        String s : list) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }
}
