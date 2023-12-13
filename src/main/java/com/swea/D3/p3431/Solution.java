package com.swea.D3.p3431;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            int L = sc.nextInt();
            int U = sc.nextInt();
            int X = sc.nextInt();

            if (X > U) {
                sb.append(-1);
            } else {
                int remainedTime = L - X;

                if (remainedTime < 0) {
                    sb.append(0);
                } else {
                    sb.append(remainedTime);
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}
