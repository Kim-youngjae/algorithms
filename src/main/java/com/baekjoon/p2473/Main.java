package com.baekjoon.p2473;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 용액 특성 계산하기
        long[] answer = calculate(N, arr);

        for (long l : answer) {
            System.out.print(l + " ");
        }
    }

    private static long[] calculate(int N, int[] arr) {
        long min = Long.MAX_VALUE;
        long[] result = new long[3];

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                long absSum = Math.abs(sum);

                if (absSum < min) {
                    min = Math.abs(sum);
                    result[0] = arr[i];
                    result[1] = arr[left];
                    result[2] = arr[right];
                }

                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        Arrays.sort(result);

        return result;
    }
}
