package com.swea.D2.p1284;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int P = 0;
            int Q = 0;
            int R = 0;
            int S = 0;
            int W = 0;
            int comA = 0;
            int comB = 0;

            P = sc.nextInt();
            Q = sc.nextInt();
            R = sc.nextInt();
            S = sc.nextInt();
            W = sc.nextInt();

            comA = P * W;
            comB = (W - R) <= 0 ? Q : ((W - R) * S) + Q;

            sb.append("#" + i + " " + Math.min(comA, comB) + "\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
