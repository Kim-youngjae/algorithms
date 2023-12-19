package com.swea.D3.p6730;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            int N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            // 난이도 계산
            int up = 0;
            int down = 0;

            int prev = 0;
            int temp = 0;

            for (int i = 0; i < N - 1; i++) {
                prev = arr[i];
                temp = arr[i + 1];

                int target = prev - temp;

                // 음수라면 오르막길
                if (target < 0) {
                    up = Math.max(up, Math.abs(target));
                } else {
                    down = Math.max(down, Math.abs(target));
                }
            }

            sb.append(up).append(" ").append(down).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}
