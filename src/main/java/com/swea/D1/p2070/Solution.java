package com.swea.D1.p2070;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // test case

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println("#" + (i + 1) + " " + check(a, b));
        }

        sc.close();
    }

    private static String check(int a, int b) {
        if (a > b) {
            return ">";
        } else if (a < b) {
            return "<";
        }
        return "=";
    }
}
