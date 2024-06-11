package com.baekjoon.p6236;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] money = new int[N];

        int min = 1, max = 1;
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, money[i]);
            max += money[i]; // 최대 값은 날마다 써야하는 모든 돈의 액수의 총합
        }

        while (min <= max) {
            int sum = 0, mid = (min + max) / 2, withdraw = 1; // 제일 처음 한 번 인출했음을 가정(mid값)

            for (int i = 0; i < N; i++) {
                sum += money[i];

                /**
                 * mid 값(현재 지정된 K원)을 넘으면 인출을 다시 해야함
                 */
                if (sum > mid) {
                    sum = money[i];
                    withdraw++;
                }
            }

            /**
             * 인출 횟수가 M번 보다 많으면 예산을 늘려서 출금을 덜하게 해야함
             * 반대로 인출 횟수가 M보다 적으면 인출 횟수를 맞추기 위해 예산을 줄이기
             */
            if (withdraw > M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(min);
    }
}
