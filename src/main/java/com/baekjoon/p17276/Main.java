package com.baekjoon.p17276;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 배열 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int angle = Integer.parseInt(st.nextToken());

            if (angle < 0) {
                angle += 360; // 음수에 360만큼 더하면 그만큼 덜 돈 시계방향
            }
            angle /= 45; // 몇 번 움직여야 하는데?

            int[][] arr = new int[n][n];
            int[][] copy = new int[n][n]; // 그 전 배열 형태를 기억해야하니까 복사본을 만들어 둔다

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    copy[i][j] = arr[i][j]; // 똑같이 복사본에도 넣어주기
                }
            }

            while (angle-- > 0) {
                rotate(n, arr, copy);
            }

            for (int[] el : arr) {
                for (int e : el) {
                    sb.append(e + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void rotate(int n, int[][] arr, int[][] copy) {
        for (int i = 0; i < n; i++) {
            copy[i][n / 2] = arr[i][i]; // 주 대각선 방향이 가운데 열로
            copy[n - 1 - i][i] = arr[n -i-1][n / 2]; // 가운데 열이 반대 주 대각선으로
            copy[n / 2][i] = arr[(n - 1) - i][i]; // 반대 주 대각선이 가운데 행으로
            copy[i][i] = arr[n / 2][i];// 가운데 행이 주 대각선으로
        }
        // 돌린 결과 반영해주기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = copy[i][j];
            }
        }
    }
}
