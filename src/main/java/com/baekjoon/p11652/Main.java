package com.baekjoon.p11652;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Map<Long, Integer> map = new HashMap<>();

        int maxCnt = 0;
        long val = 0L;

        for (int i = 0; i < N; i++) {
            long target = sc.nextLong();

            if (map.containsKey(target)) { // 값이 있으면
                map.replace(target, map.get(target) + 1);
            } else {
                map.put(target, 1); // 값이 없으면
            }

            if (map.get(target) > maxCnt) {
                maxCnt = map.get(target);
                val = target;
            } else if (map.get(target) == maxCnt) {
                val = (long) Math.min(target, val);
            }
        }

        System.out.println(val);
        sc.close();
    }
}
