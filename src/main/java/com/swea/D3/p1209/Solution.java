package com.swea.D3.p1209;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[100][100];

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int crossMax1 = 0; // 대각성분1 저장
            int crossMax2 = 0; // 대각성분2 저장
            int rowMax = 0; // 행
            int colMax = 0; // 열
            int tempRowSum = 0;
            int tempColSum = 0;

            for (int i = 0; i < 100; i++) {
                rowMax = Math.max(rowMax, tempRowSum);
                colMax = Math.max(colMax, tempColSum);

                tempRowSum = 0;
                tempColSum = 0;

                for (int j = 0; j < 100; j++) {
                    if (i == j) { // 대각성분1 저장
                        crossMax1 += arr[i][j];
                    }
                    if (i + j == N - 1) { // 대각성분2 저장
                        crossMax2 += arr[i][j];
                    }

                    tempRowSum += arr[i][j];
                    tempColSum += arr[j][i];
                }
            }

            int result = Math.max(crossMax1, Math.max(crossMax2, Math.max(rowMax, colMax)));

            sb.append("#" + t + " " + result + "\n");
        }

        System.out.println(sb);
        br.close();
    }
}
