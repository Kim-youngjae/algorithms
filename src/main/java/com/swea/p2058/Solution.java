package com.swea.p2058;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        char[] arr = String.valueOf(N).toCharArray();

        int sum = 0;

        for (char c : arr) {
            sum += c - '0';
        }

        System.out.println(sum);
        sc.close();
    }
}
