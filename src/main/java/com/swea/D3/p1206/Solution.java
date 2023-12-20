package com.swea.D3.p1206;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 조망권 계산
            int count = 0;

            for (int i = 2; i < N - 2; i++) {
                int target = arr[i];

                // 하나라도 빌딩 높이가 크거나 같아도 조망권 확보x
                if (arr[i - 2] < target && arr[i - 1] < target && arr[i + 1] < target && arr[i + 2] < target) {
                    int maxHeight = Math.max(Math.max(arr[i + 1], arr[i + 2]), Math.max(arr[i - 2], arr[i - 1]));
                    count += target - maxHeight;
                }
            }

            sb.append("#").append(t).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }
}
