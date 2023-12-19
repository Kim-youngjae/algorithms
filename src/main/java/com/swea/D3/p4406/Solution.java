package com.swea.D3.p4406;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            String word = sc.next();

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    continue;
                } else {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
