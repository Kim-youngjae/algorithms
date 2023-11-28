package com.baekjoon.p10815;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Integer> list;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        map = new LinkedHashMap<>();
        list = new ArrayList<>(M);

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, 0);
            list.add(key);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (int i : arrN) {
            search(i);
        }

        for (int i : keys) {
            sb.append(map.get(i) + " ");
        }

        System.out.println(sb);
    }

    private static void search(int target) {
        int start = 0;
        int end = M - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (target == list.get(mid)) {
                map.replace(target, 1);
                return;
            }

            if (target > list.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}
