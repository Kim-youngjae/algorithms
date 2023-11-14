package com.baekjoon.p1802;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static String paper;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            paper = sc.next();
            if (canFold(0, paper.length() - 1)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
        sc.close();
    }

    private static boolean canFold(int start, int end) {
        if (start == end) {
            return true;
        }

        int center = (start + end) / 2;

        for (int i = start; i < center; i++) {
            if (paper.charAt(i) == paper.charAt(end - i)) {
                return false;
            }
        }

        return canFold(start, center - 1) && canFold(center + 1, end);
    }
}
