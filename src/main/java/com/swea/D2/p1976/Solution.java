package com.swea.D2.p1976;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int hour1 = sc.nextInt();
            int minute1 = sc.nextInt();
            int hour2 = sc.nextInt();
            int minute2 = sc.nextInt();

            int hourBit = (minute1 + minute2) / 60;

            int minuteResult = (minute1 + minute2) % 60;

            int hourResult = (hour1 + hour2 + hourBit) % 12;

            if (hourResult == 0) {
                hourResult = 12;
            }

            sb.append("#").append(t).append(" ");
            sb.append(hourResult).append(" ").append(minuteResult).append("\n");
        }

        System.out.println(sb);

        sc.close();
    }
}
