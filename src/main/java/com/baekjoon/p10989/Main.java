package com.baekjoon.p10989;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.valueOf(br.readLine());

        int[] numArr = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(numArr);

        for (int i : numArr) {
            sb.append(i + "\n");
        }

        System.out.println(sb);
    }
}
