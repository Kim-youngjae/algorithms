package com.baekjoon.math.p10872;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(factorial(N));
        sc.close();
    }

    static int factorial(int N) {
        if (N <= 1) {
            return 1;
        }

        return N * factorial(N - 1);
    }
}
