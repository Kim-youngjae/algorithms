package com.baekjoon.math.p1978;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] isPrime = new boolean[1001];

        for (int i = 0; i < 1001; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < Math.sqrt(1000); i++) {
            // 소수라면 소수를 포함한 배수를 제거한다.
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int cnt = 0;
        for (int i : num) {
            if (isPrime[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
