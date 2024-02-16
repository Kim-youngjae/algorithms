package com.swea.D3.p5215;

import java.io.*;
import java.util.*;

public class Solution {
    static int[] taste, cal;
    static int N, L, maxScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            taste = new int[N];
            cal = new int[N];
            maxScore = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                taste[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());

            }

            combination(0, 0, 0);

            sb.append(maxScore + "\n");
        }

        System.out.println(sb);
    }

    private static void combination(int cnt, int tstScore, int calories) {

        if (calories > L) {
            return;
        }

        if (cnt == N) { // 부분 집합이 완성되면
            if (calories <= L) {
                maxScore = Math.max(tstScore, maxScore);
            }
            return;
        }

        // 부분 집합에 포함하는 경우
        combination(cnt + 1, tstScore + taste[cnt], calories + cal[cnt]);

        // 부분 집합에 포함하지 않는 경우
        combination(cnt + 1, tstScore, calories);
    }
}
