package com.baekjoon.p1927;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < N; i++) {
            int val = sc.nextInt();

            if (val == 0) {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll() + "\n");
                }
            } else {
                pq.offer(val);
            }
        }
        System.out.println(sb);
        sc.close();
    }
}
