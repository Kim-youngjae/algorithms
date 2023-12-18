package com.baekjoon.p1253;

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

        Arrays.sort(arr); // 우선 정렬

        int cnt = 0; // 개수를 저장할 변수

        for (int i = 0; i < N; i++) {

            int T = arr[i];

            int start = 0;
            int end = N - 1;

            while (start < end) {
                int sum = arr[start] + arr[end];

                if (sum == T) {
                    if (start != i && end != i) { // 자기 자신이 start 또는 end에 포함이 되있는지 확인
                        cnt++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else {
                        end--;
                    }
                } else if (sum > T) {
                    end--;
                } else if (sum < T) {
                    start++;
                }
            }
        }

        System.out.println(cnt);
    }
}
