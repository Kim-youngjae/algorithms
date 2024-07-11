package com.baekjoon.data_structure.p1302;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<String> keyList = new ArrayList<>();
        for (String s : map.keySet()) {
            keyList.add(s);
        }

        Collections.sort(keyList);

        int topSaleAmt = 0;
        int topSaleIdx = 0;

        for (int i = 0; i < keyList.size(); i++) {
            String key = keyList.get(i);

            if (map.get(key) > topSaleAmt) {
                topSaleAmt = map.get(key);
                topSaleIdx = i;
            } else if (map.get(key) == topSaleAmt && topSaleIdx > i) {
                topSaleIdx = i;
            }
        }

        System.out.println(keyList.get(topSaleIdx));
    }
}
