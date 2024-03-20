package com.baekjoon.p1629;

import java.io.*;
import java.util.*;

public class Main {
    static long A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    static long pow(long A, long exponent) {

        if (exponent == 1) {
            return A % C;
        }

        // 지수 법칙에 따라 지수를 반으로 줄인 값을 구한다.
        long temp = pow(A, exponent / 2);

        // 홀수 지수 이면 한번을 더 곱해줘야 한다.
        if (exponent % 2 == 1) {
            return ((temp * temp % C) * (A % C)) % C;
        }

        // 지수가 짝수이면 한번 더 곱해주지 않고 그대로 지수법칙에 따라 서로 곱하여 모듈러 연산만 수행한다.
        return (temp * temp) % C;
    }
}
