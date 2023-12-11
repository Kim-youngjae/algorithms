package com.swea.D2.p1984;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int[] arr = new int[10];

            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            double sum = 0;

            for (int i = 1; i < 9; i++) {
                sum += arr[i];
            }

            sb.append("#").append(t).append(" ").append(Math.round(sum / 8)).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
