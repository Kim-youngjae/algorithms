package com.swea.D1.p2071;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int sum = 0;

            for (int j = 0; j < 10; j++) {
                int num = sc.nextInt();

                sum += num;
            }

            System.out.printf("#%d %.0f\n", i + 1, sum / 10.0);
        }

        sc.close();
    }
}
