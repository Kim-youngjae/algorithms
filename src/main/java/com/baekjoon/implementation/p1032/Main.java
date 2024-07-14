package com.baekjoon.implementation.p1032;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        char[] pattern = br.readLine().toCharArray();
        int len = pattern.length;

        for (int t = 1; t < T; t++) {

            String compareStr = br.readLine();

            for (int i = 0; i < len; i++) {
                if (pattern[i] != compareStr.charAt(i)) {
                    pattern[i] = '?';
                }
            }
        }

        for (int i = 0; i < len; i++) {
            sb.append(pattern[i]);
        }
        System.out.println(sb);
    }
}
