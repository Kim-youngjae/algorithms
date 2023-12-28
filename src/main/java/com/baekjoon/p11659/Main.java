package com.baekjoon.p11659;

import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        int accumSum = 0;
        for (int i = 0; i < N; i++) {
            accumSum += Integer.parseInt(st.nextToken());
            arr[i] = accumSum;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int startIndex = Integer.parseInt(st.nextToken()) - 1;
            int endIndex = Integer.parseInt(st.nextToken()) - 1;

            int result;

            if (startIndex == 0) {
                result = arr[endIndex];
            } else {
                result = arr[endIndex] - arr[startIndex - 1];
            }

            sb.append(result + "\n");
        }

        System.out.println(sb);
    }

}
