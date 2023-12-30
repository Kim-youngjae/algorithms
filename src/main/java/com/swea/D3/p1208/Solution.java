package com.swea.D3.p1208;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int dump = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] arr = new int[100];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < dump; i++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[99]--;
            }

            Arrays.sort(arr);

            sb.append("#" + t + " ");
            sb.append(arr[99] - arr[0] + "\n");
        }

        System.out.println(sb);
    }
}
