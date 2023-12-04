package com.baekjoon.p10816;

import java.util.*;

public class Main {

    static List<Integer> sortedList;
    static int M;
    static Map<Integer, Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] array1 = new int[N];

        for (int i = 0; i < N; i++) {
            array1[i] = sc.nextInt();
        }

        M = sc.nextInt();
        int[] array2 = new int[M];

        for (int i = 0; i < M; i++) {
            int key = sc.nextInt();
            array2[i] = key;
            map.put(key, 0);
        }

        sortedList = new ArrayList<>();

        for (int i : array2) {
            sortedList.add(i);
        }

        Collections.sort(sortedList);

        for (int i : array1) {
            binarySearch(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int k : sortedList) {
            sb.append(map.get(k)).append(" ");
        }

        System.out.println(sb);
        sc.close();
    }

    private static void binarySearch(int target) {
        int start = 0;
        int end = M - 1;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (target == sortedList.get(mid)) {
                map.replace(target, map.get(target) + 1);
                return;
            }
            if (target > sortedList.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}
