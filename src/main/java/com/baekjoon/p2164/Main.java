package com.baekjoon.p2164;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            if (q.size() == 1) {
                break;
            }

            q.remove();

            int reuseValue = q.remove();

            q.add(reuseValue);
        }

        System.out.println(q.peek());
        sc.close();
    }
}
