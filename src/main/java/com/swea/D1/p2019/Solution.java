package com.swea.D1.p2019;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            System.out.printf("%d ", (int) Math.pow(2, i));
        }

        sc.close();
    }
}