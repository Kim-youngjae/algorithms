package com.baekjoon.p1459;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long X = 0;
    static long Y = 0;
    static long W = 0;
    static long S = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 좌표
        X = Long.valueOf(st.nextToken());
        Y = Long.valueOf(st.nextToken());
        // 블럭 이동 시간
        W = Integer.valueOf(st.nextToken());
        S = Integer.valueOf(st.nextToken());

        long case1, case2, case3;

        case1 = (X + Y) * W; // 평행으로만 이동

        if ((X + Y) % 2 == 0) {
            case2 = Math.max(X, Y) * S; // 대각선으로만 이동
        } else {
            case2 = (Math.max(X, Y) - 1) * S + W; // 대각선으로 이동, 좌표 합이 홀수라 평행이동을 해야할 때
        }

        case3 = (Math.min(X, Y) * S) + (Math.abs(X - Y) * W);

        System.out.println(Math.min(case1, Math.min(case2, case3)));
    }
}