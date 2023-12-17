package com.swea.D3.p10505;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            long sum = 0L;

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            Arrays.sort(arr); // 배열 정렬
            int avg = (int) sum / N;
            int cnt = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= avg) {
                    cnt++;
                }
                if (arr[i] > avg) {
                    break;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
