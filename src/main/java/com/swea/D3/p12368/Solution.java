package com.swea.D3.p12368;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            sb.append("#" + t + " " + ((A + B) % 24) + "\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
