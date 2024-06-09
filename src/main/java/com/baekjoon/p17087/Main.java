package com.baekjoon.p17087;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs(Integer.parseInt(st.nextToken()) - s); // s와 거리 구하기
        }

        int d = arr[0];

        /**
         * 모든 배열을 돌면서 최대공약수를 구하고 구한 공약수와 다음 배열의 수의 최대 공약수 구하기
         */
        for (int i = 0; i < n; i++) {
            d = gcd(d, arr[i]);
        }

        System.out.println(d);
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
