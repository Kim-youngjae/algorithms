package com.swea.D1.p2043;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(Math.abs(P - K) + 1);
        sc.close();
    }
}
