package com.swea.D2.p1948;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int m1 = sc.nextInt();
            int d1 = sc.nextInt();
            int m2 = sc.nextInt();
            int d2 = sc.nextInt();

            int days = 0;

            if (m1 == m2) {
                days = (d2 - d1 + 1);
                sb.append("#" + t + " " + days + "\n");
            } else {

                for (int i = m1; i < m2; i++) {
                    days += month[i - 1];
                }

                days += (d2 - d1 + 1);

                sb.append("#" + t + " " + days + "\n");
            }
        }
        System.out.print(sb);
        sc.close();
    }
}
