package com.baekjoon.p11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] priceOfStock = new long[N];
            long topPrice = 0;
            long profit = 0;

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                priceOfStock[j] = Integer.parseInt(st.nextToken()); // 주식의 가격을 저장
            }

            for (int d = N - 1; d >= 0; d--) {
                if (topPrice < priceOfStock[d]) {
                    topPrice = priceOfStock[d];
                } else {
                    profit += (topPrice - priceOfStock[d]);
                }
            }

            System.out.println(profit);
        }

    }
}
