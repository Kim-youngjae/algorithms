package com.baekjoon.p1874;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        int start = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int val = sc.nextInt();

            if (val > start) {
                for (int j = start + 1; j <= val; j++) {
                    stack.push(j);
                    sb.append("+" + "\n");
                }
                start = val;
            } else if (stack.peek() != val) {
                System.out.println("NO");
                sc.close();
                return;
            }

            sb.append("-" + "\n");
            stack.pop();
        }

        System.out.println(sb);
        sc.close();
    }
}
