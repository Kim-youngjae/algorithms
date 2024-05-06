package com.swea.D3.p5601;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            int N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                sb.append("1/" + N + " ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
