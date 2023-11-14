package com.swea.D1.p2072;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int sum = 0;

            for (int j = 0; j < 10; j++) {
                int num = sc.nextInt();

                if (num % 2 == 1) {
                    sum += num;
                }
            }

            System.out.printf("#%d %d\n", i + 1, sum);
        }

        sc.close();
    }
}
