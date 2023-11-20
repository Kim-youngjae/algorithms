package com.baekjoon.p11931;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.valueOf(br.readLine());

        Integer[] numArr = new Integer[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(numArr, Collections.reverseOrder());

        for (int i : numArr) {
            sb.append(i + "\n");
        }

        System.out.println(sb);
    }
}
