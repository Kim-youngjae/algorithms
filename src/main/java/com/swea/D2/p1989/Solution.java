package com.swea.D2.p1989;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            String word = sc.next();
            int result = 1;

            for (int j = 0; j < word.length() / 2 + 1; j++) {
                if (word.charAt(j) != word.charAt(word.length() - j - 1)) {
                    result = 0;
                    break;
                }
            }
            sb.append("#" + i + " " + result + "\n");
        }
        System.out.println(sb);
        sc.close();
    }
}
