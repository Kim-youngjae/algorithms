package com.baekjoon.p4948;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 2 * 123456;
        boolean[] isPrime = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {

            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime[i]) {
                    cnt++;
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }
}
