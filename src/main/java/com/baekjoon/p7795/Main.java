package com.baekjoon.p7795;

import java.util.*;

public class Main {
    static int[] A;
    static int[] B;
    static int N;
    static int M;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            result = 0;
            N = sc.nextInt();
            M = sc.nextInt();

            A = new int[N];
            B = new int[M];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt(); // A 배열 입력
            }

            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt(); // B 배열 입력
            }
            Arrays.sort(B); // 이분 탐색을 하려고 하는 대상만 정렬해주면 됨

            for (int i = 0; i < N; i++) {
                binarySearch(A[i]);
            }

            sb.append(result + "\n");
        }
        System.out.println(sb);
        sc.close();
    }

    private static void binarySearch(int target) {
        int start = 0; // 시작
        int end = M - 1; // 끝 B의 끝
        int mid = 0; // 가운데

        while (start <= end) { //
            mid = (start + end) / 2;

            if (target > B[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        result += start; // start 보다 작으건 모두 먹을 수 있어서 쌍으로 분류
    }
}
