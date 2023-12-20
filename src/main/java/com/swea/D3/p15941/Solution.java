package com.swea.D3.p15941;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            sb.append("#" + t + " " + (int) Math.pow(N, 2) + "\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
