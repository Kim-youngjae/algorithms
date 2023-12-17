package com.swea.D3.p13218;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ")
                    .append(sc.nextInt() / 3).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
