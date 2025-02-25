package com.baekjoon.sorting.p2309;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[i] = value;
        }

        A: for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    break A;
                }
            }
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i < 9; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
