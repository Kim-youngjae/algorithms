package com.baekjoon.sorting.p2470;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] elements = new long[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(elements);

        int l = 0, r = elements.length - 1;
        long min = Integer.MAX_VALUE, val1 = 0, val2 = 0;

        while (l < r) {
            long sum = elements[l] + elements[r];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                val1 = elements[l];
                val2 = elements[r];

                if (sum == 0) {
                    break;
                }
            }

            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(val1 + " " + val2);
    }
}
