package com.baekjoon.p2003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] numList = new int[n];

        for (int i = 0; i < n; i++) {
            numList[i] = sc.nextInt();
        }

        int start = 0; // 시작 포인트
        int end = 0; // 끝 포인트
        int sum = 0;
        int cnt = 0;

//        while (true) {
//            if (sum == m) {
//                cnt++;
//            }
//
//            if (sum >= m) {
//                sum -= numList[start++];
//            } else if (end >= n) {
//                break;
//            } else {
//                sum += numList[end++];
//            }
//        }

        while (end <= n) {
            if (sum >= m) {
                sum -= numList[start++];
            } else {
                if (end == n) {
                    break;
                }
                sum += numList[end++];
            }
            if (sum == m) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}