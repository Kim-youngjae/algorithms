package com.swea.D2.p1288;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            Set<Integer> set = new HashSet<>();
            int N = sc.nextInt();
            int num = 0;

            while (set.size() < 10) {
                num += N;
                String strNum = String.valueOf(num);

                for (int j = 0; j < strNum.length(); j++) {
                    int target = strNum.charAt(j) - '0';

                    set.add(target);
                }
            }

            System.out.printf("#%d %d\n", i, num);
        }

        sc.close();
    }
}
