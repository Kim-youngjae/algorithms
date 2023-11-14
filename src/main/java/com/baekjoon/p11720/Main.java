package com.baekjoon.p11720;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String sNum = sc.next();

        char[] cNum = sNum.toCharArray();

        int sum = 0;

        for (char c : cNum) {
            sum += (c - '0');
        }

        System.out.println(sum);
        sc.close();
    }
}
