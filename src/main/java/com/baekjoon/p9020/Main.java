package com.baekjoon.p9020;

import java.io.*;
import java.util.*;

public class Main {
    static int N = 10_000;
    static boolean[] isPrime;
    static int[] ans;
    static int diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 소수 판별
        init();

        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스 시작
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            ans = new int[2]; // 정답을 넣을 배열
            diff = Integer.MAX_VALUE;

            // n보다 작은 수 중에서 소수와 뺄셈의 결과가 소수인 수들을 구하기
            for (int i = 2; i <= n; i++) {
                if (isPrime[i]) {
                    int result = n - i;

                    if (isPrime[result] && (Math.abs(result - i) < diff)) {
                        ans[0] = i;
                        ans[1] = result;
                        diff = Math.abs(result - i);
                        Arrays.sort(ans);
                    }
                }
            }
            sb.append(ans[0] + " " + ans[1] + "\n");
        }

        System.out.print(sb);
        br.close();
    }

    static void init() {
        isPrime = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false; // 0, 1 소수에서 제외

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
