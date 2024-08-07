package com.baekjoon.implementation.p2525;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int min = sc.nextInt();
        int C = sc.nextInt();

        int h = (min + C) / 60;
        int m = (min + C) % 60;

        hour += h;

        System.out.println((hour % 24) + " " + m);
        sc.close();
    }
}
