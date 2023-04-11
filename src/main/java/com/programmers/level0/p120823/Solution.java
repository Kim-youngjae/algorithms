package com.programmers.level0.p120823;
//https://school.programmers.co.kr/learn/courses/30/lessons/120823

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("*".repeat(i));
        }

    }
}