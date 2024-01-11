package com.baekjoon.p6198;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Stack<Integer> s = new Stack<>();

        long result = 0;

        for (int i = 0; i < N; i++) {
            int height = sc.nextInt();

            while (!s.isEmpty()) {
                if (s.peek() <= height) {
                    s.pop();
                } else {
                    break;
                }
            }

            result += s.size();

            s.push(height);
        }

        System.out.println(result);
        sc.close();
    }
}
