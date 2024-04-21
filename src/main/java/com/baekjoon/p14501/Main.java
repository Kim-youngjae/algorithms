package com.baekjoon.p14501;

import java.io.*;
import java.util.*;

public class Main {
    static int max, N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;

        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int day, int pay) {
        if (day >= N) {
            max = Math.max(max, pay);
            return;
        }

        if (day + arr[day][0] <= N) { // 상담을 시작해서 끝나도 아직 퇴사일보다 작다면 상담을 할 수 있다.
            dfs(day + arr[day][0], pay + arr[day][1]);
        } else {
            dfs(day + arr[day][0], pay); // 상담을 퇴사 전까지 끝내지 못하면 일수만 더해서 종료조건에 걸리도록
        }

        dfs(day + 1, pay); // 1일 ~ 퇴사일까지의 날짜까지 모두 고려하기
    }
}
