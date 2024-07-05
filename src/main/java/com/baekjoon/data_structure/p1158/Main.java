package com.baekjoon.data_structure.p1158;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int cnt = 1;

        while (!dq.isEmpty()) {
            if (cnt == K) {
                sb.append(dq.poll());
                if (!dq.isEmpty()) {
                    sb.append(", ");
                } else {
                    sb.append(">");
                }
                cnt = 1;
            } else {
                dq.add(dq.poll());
                cnt++;
            }
        }

        System.out.println(sb);
        sc.close();
    }
}
