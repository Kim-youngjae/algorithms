package com.baekjoon.p5648;

import java.io.*;
import java.util.*;

public class Main {
    static long[] numArr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        numArr = new long[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = reverseNumber(sc.next());
        }

        Arrays.sort(numArr);

        for (long i : numArr) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
        sc.close();
    }

    private static Long reverseNumber(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return Long.parseLong(sb.toString());
    }
}
