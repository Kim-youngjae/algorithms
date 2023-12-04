package com.swea.D2.p1926;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for (int n = 1; n <= N; n++) {
            String num = String.valueOf(n);
            boolean flag = false;

            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) == '3' || num.charAt(i) == '6' || num.charAt(i) == '9') {
                    sb.append("-");
                    flag = true;
                }
            }

            if (!flag) {
                sb.append(num);
            }

            sb.append(" ");
        }
        System.out.println(sb);
        sc.close();
    }
}
