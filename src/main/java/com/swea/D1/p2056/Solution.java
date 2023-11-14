package com.swea.D1.p2056;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[] limit = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        for (int i = 0; i < T; i++) {
            int ymd = sc.nextInt();

            int year = ymd / 10000;
            int month = (ymd - year * 10000) / 100;
            int date = ymd % 100;

            if ((month < 1 || month > 12) || (date < 1 || date > limit[month - 1])) {
                System.out.printf("#%d -1\n", i + 1);
            } else {
                System.out.printf("#%d %04d/%02d/%02d\n", i + 1, year, month, date);
            }
        }
    }
}