package com.baekjoon.implementation.p3003;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int king = 1, queen = 1, rooks = 2, bishops = 2, knights = 2, pawns = 8;

        System.out.print(king - sc.nextInt() + " ");
        System.out.print(queen - sc.nextInt() + " ");
        System.out.print(rooks - sc.nextInt() + " ");
        System.out.print(bishops - sc.nextInt() + " ");
        System.out.print(knights - sc.nextInt() + " ");
        System.out.print(pawns - sc.nextInt());
        sc.close();
    }
}
