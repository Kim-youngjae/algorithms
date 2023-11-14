package com.swea.p2068;

import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // test case

        for (int i = 0; i < t; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < 10; j++) {
                int target = sc.nextInt();
                max = max < target ? target : max;
            }

            System.out.printf("#%d %d\n", i + 1, max);
        }

        sc.close();
    }
}
