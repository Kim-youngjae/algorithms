package com.baekjoon.p2588;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        ArrayList<Integer> al = new ArrayList<>(3);
        char[] chars = String.valueOf(n2).toCharArray();

        for (char c : chars) {
            al.add(n1 * Integer.valueOf(c - 48));
        }

        for (int i = al.size() - 1; i >= 0; i--) {
            System.out.println(al.get(i));
        }
        System.out.println((n1 * n2));
    }
}
