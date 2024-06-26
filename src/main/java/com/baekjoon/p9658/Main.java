package com.baekjoon.p9658;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N % 7 == 1 || N % 7 == 3) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

        sc.close();
    }
}
