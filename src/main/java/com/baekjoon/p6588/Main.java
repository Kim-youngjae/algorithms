package com.baekjoon.p6588;

import java.io.*;

public class Main {
    static final int N = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isNotPrime = new boolean[N + 1];

        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i < Math.sqrt(N); i++) {

            if (!isNotPrime[i]) {
                /**
                 * i가 소수라면 i보다 큰 i의 모든 배수들은 소수가 될 수 없다.
                 */
                for (int j = i * i; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        // test case 입력
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            boolean ans = false;

            for (int a = 2; a <= n / 2; a++) {
                if (!isNotPrime[a] && !isNotPrime[n - a]) {
                    sb.append(n + " = " + a + " + " + (n - a) + "\n");
                    ans = true;
                    break;
                }
            }

            if (!ans) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }

        System.out.println(sb);

    }
}
