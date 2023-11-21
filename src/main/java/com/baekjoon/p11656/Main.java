package com.baekjoon.p11656;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String target = sc.next();
        int l = target.length();

        String[] suffixes = new String[l];

        for (int i = 0; i < l; i++) {
            suffixes[i] = target.substring(i);
        }

        Arrays.sort(suffixes);

        for (String suffix : suffixes) {
            sb.append(suffix).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
