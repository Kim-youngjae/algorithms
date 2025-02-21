package com.baekjoon.p1676;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();

        String str = String.valueOf(factorial(n));
        Stack<Character> st = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);

            if (c != '0') {
                break;
            } else {
                st.push(c);
            }
        }

        if (st.isEmpty()) {
            System.out.print('0');
        } else {
            System.out.print(st.size());
        }

        in.close();

    }

    static long factorial(long n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
