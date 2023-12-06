package com.baekjoon.p16401;

import java.io.*;
import java.util.*;

public class Main {
    static int M, N, result;
    static int[] cookies;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken()); // 조카 수
        N = Integer.parseInt(st.nextToken()); // 과자 수

        cookies = new int[N];
        int maxLen = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cookies[i] = Integer.parseInt(st.nextToken());
            maxLen = Math.max(maxLen, cookies[i]);
        }

        binarySearch(cookies, 1, maxLen);

        System.out.println(result);
    }

    private static void binarySearch(int[] cookies, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            int count = 0;

            for (int i : cookies) {
                count += i / mid; // 나눈 몫을 저장
            }

            if (count >= M) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}
