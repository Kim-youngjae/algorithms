package com.baekjoon.p17103;

import java.io.*;

public class Main {
    static boolean[] isPrime;
    static final int num = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 소수 구하기
        isPrime = new boolean[num];

        for (int i = 2; i < num; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (!isPrime[i])
                continue;

            for (int j = i * i; j < num; j += i) {
                isPrime[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0; // 합이 짝수이면 카운트

            // 절반 이상을 넘겨서 탐색을 하면 중복되는 수열이 발생해서 N / 2까지만 탐색
            for (int i = 2; i <= N / 2; i++) {
                if (isPrime[i]) { // 해당 수가 소수 일 때
                    if (isPrime[N - i]) { // 그 수만큼 뺀 수가 소수라면 카운트
                        cnt++;
                    }
                }
            }

            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}
