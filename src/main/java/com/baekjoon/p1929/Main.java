package com.baekjoon.p1929;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxNum = 1_000_000;

        boolean[] isDecimal = new boolean[maxNum + 1];

        for (int i = 0; i <= maxNum; i++) {
            isDecimal[i] = true;
        }

        isDecimal[0] = isDecimal[1] = false;

        for (int i = 2; i <= Math.sqrt(maxNum); i++) {
            if (isDecimal[i]) {
                for (int j = i * i; j <= maxNum; j += i) {
                    isDecimal[j] = false;
                }
            }
        }

        String input = br.readLine();

        String[] s = input.split(" ");

        int M = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (isDecimal[i]) {
                sb.append(i + "\n");
            }
        }

        System.out.println(sb);
    }
}
