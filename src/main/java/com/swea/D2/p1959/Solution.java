package com.swea.D2.p1959;

import java.util.*;

public class Solution {
    static int[] A;
    static int[] B;
    static int startIdx = 0;
    static int lastIdx = 0;
    static int result = Integer.MIN_VALUE;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            A = new int[N];
            B = new int[M];

            init(N, A);
            init(M, B);

            // 더 긴 배열 길이를 구하기
            int maxLen = Math.max(A.length, B.length);
            int minLen = Math.min(A.length, B.length);
            lastIdx = startIdx + minLen - 1;

            // 마지막 인덱스가 maxLen - 1(긴 배열의 마지막 인덱스)보다 크면 안됨
            while (lastIdx < maxLen) {

                int sum = 0;
                int i = 0;

                // 곱한 값을 모두 더하기
                if (A.length == minLen) {
                    for (int s = startIdx; s <= lastIdx; s++) {
                        sum += A[i++] * B[s];
                    }
                } else {
                    for (int s = startIdx; s <= lastIdx; s++) {
                        sum += A[s] * B[i++];
                    }
                }

                // 최종 합을 result와 비교해 더 큰 값 구하기
                result = result < sum ? sum : result;
                // 시작인덱스 증가
                startIdx++;
                lastIdx = startIdx + minLen - 1;
            }

            // 모두 돌았을 때 가장 큰 값이 저장되어있으므로 result출력
            sb.append("#" + t + " " + result + "\n");
            result = Integer.MIN_VALUE;
            startIdx = 0;
        }

        System.out.print(sb);
        sc.close();
    }

    private static void init(int x, int[] target) {
        for (int i = 0; i < x; i++) {
            target[i] = sc.nextInt();
        }
    }
}
