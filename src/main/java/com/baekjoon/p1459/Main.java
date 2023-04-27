package com.baekjoon.p1459;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long X;
    static long Y;
    static long W;
    static long S;

    static long minStraightMoveTwo;

    static long totalTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        long square = Math.min(X, Y); // 최대한 움직일 수 있는 정사각형의 범위
        long moveSquare = Math.min(square * 2 * W, square * S); // 일직선으로 두번씩 이동해 도착하는 경우 대각선으로만 쭉 가서 도착하는 경우

        long line = Math.max(X, Y) - square; // 최대한 정사각형으로 움직일 수 있는 거리를 빼고 일직선으로만 이동해야 하는 거리(대각선으로 들리는 경우도 가능)

        long moveRest;
        if (line % 2 == 0) {
            moveRest = line * S; // 2로 나누어 떨어지면
        } else {
            moveRest = (line - 1) * S + W;
        }
        moveRest = Math.min(line * W, moveRest);

        System.out.println(moveSquare + moveRest);
    }
}