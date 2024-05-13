package com.baekjoon.p1904;

import java.io.*;

public class Main {
    static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new Integer[1000001];

        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= N; i++) {
            arr[i] = (arr[i - 1] % 15746 + arr[i - 2] % 15746) % 15746;
        }

        System.out.println(arr[N]);
    }
}
