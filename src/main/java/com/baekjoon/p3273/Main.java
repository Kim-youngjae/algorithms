package com.baekjoon.p3273;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N]; // 범위 확인 잘하기..

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        Arrays.sort(arr); // 문제 잘 읽기.. 문제에서 i <= j를 만족한다고 했음

        int l = 0, r = N - 1, sum = 0, cnt = 0;

        while (l < r) {
            sum = arr[l] + arr[r];

            if (sum == X) {
                cnt++;
            }

            if (sum <= X) {
                l++;
            } else {
                r--;
            }

        }

        System.out.println(cnt);

    }
}
