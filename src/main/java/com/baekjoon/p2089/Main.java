package com.baekjoon.p2089;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        if (N == 0) {
            System.out.println(0);
        } else {
            while (N != 1) {
                sb.append(Math.abs(N % -2));
                N = (int) Math.ceil((double) N / (-2));
            }
            sb.append(N);
            System.out.println(sb.reverse());
        }

        sc.close();
    }
}
