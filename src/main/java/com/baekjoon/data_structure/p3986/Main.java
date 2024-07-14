package com.baekjoon.data_structure.p3986;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int cnt = 0;

        while (T-- > 0) {
            Stack<Character> stack = new Stack<>();
            String str = sc.next();

            for (int i = 0; i < str.length(); i++) {
                char now = str.charAt(i);

                if (stack.isEmpty()) {
                    stack.push(now);
                } else {
                    if (stack.peek() == now) {
                        stack.pop();
                    } else {
                        stack.push(now);
                    }
                }
            }

            if (stack.isEmpty()) {
                cnt++;
            }
        }

        System.out.println(cnt);
        sc.close();
    }
}
