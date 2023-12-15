package com.baekjoon.p2143;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 만들고자 하는 수

        int n = Integer.parseInt(br.readLine());

        int[] arrA = new int[n];
        int sum = 0;
        int[] accumA = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
            sum += arrA[i];
            accumA[i] += sum;
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m];
        int[] accumB = new int[m];
        sum = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
            sum += arrB[i];
            accumB[i] += sum;
        }

        Arrays.sort(accumA);
        Arrays.sort(accumB);

        int pa = 0;
        int pb = accumB.length - 1;
        int cnt = 0; // 가능한 쌍의 개수를 저장할 변수

        while (pa < accumA.length && pb >= 0) { // 두 배열을 넘어가지 않을 동안 반복
            int total = accumA[pa] + accumB[pb];

            if (total == T) {
                int aCnt = 0;
                int bCnt = 0;

                int a = accumA[pa];
                int b = accumB[pb];

                while (pa < accumA.length && accumA[pa] == a) {
                    aCnt++;
                    pa++;
                }
                while (pb >= 0 && accumB[pb] == b) {
                    bCnt++;
                    pb--;
                }

                cnt += aCnt * bCnt; // 동일한 갯수 세기
            } else if (total > T) {
                pb--;
            } else if (total < T) {
                pa++;
            }

        }

        System.out.println(cnt);

    }
}
