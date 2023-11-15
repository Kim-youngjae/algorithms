package com.swea.D2.p1986;

import java.io.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.valueOf(br.readLine());

        for (int i = 1; i <= T; i++) {
            int sum = 0;
            int N = Integer.valueOf(br.readLine());

            for (int j = 1; j <= N; j++) {
                if (j % 2 == 0) {
                    sum -= j;
                } else {
                    sum += j;
                }
            }
            sb.append("#" + i + " " + sum + "\n");
        }

        System.out.print(sb);

        br.close();
    }
}
