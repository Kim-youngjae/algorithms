package com.swea.D2.p1204;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int tc = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");

            Map<Integer, Integer> map = new HashMap<>();

            int maxCount = 0;
            int maxValue = 0;

            while (st.hasMoreTokens()) {
                int key = Integer.parseInt(st.nextToken());
                map.put(key, map.getOrDefault(key, 0) + 1);

                if (map.get(key) >= maxCount) {
                    maxCount = map.get(key);
                    maxValue = key;
                }

            }

            sb.append("#").append(tc).append(" ").append(maxValue).append("\n");
        }

        System.out.println(sb);
    }
}
