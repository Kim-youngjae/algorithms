package com.baekjoon.p5585;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int money = 1000 - sc.nextInt();
        int count = 0;

        int[] changes = new int[] { 500, 100, 50, 10, 5, 1 };

        for (int i = 0; i < changes.length; i++) {
            count += money / changes[i];
            money = money % changes[i];
        }

        System.out.println(count);
        sc.close();
    }
}
