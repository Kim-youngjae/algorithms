package com.baekjoon.p10773;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < K; i++) {
            int val = sc.nextInt();

            if (val == 0) {
                s.pop();
            } else {
                s.push(val);
            }
        }

        int sum = 0;

        while (!s.isEmpty()) {
            sum += s.pop();
        }

        System.out.println(sum);
        sc.close();
    }
}
