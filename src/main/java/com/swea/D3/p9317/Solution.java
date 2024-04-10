package com.swea.D3.p9317;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            int N = Integer.parseInt(br.readLine());
            String s1 = br.readLine();
            String s2 = br.readLine();
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    cnt++;
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }
}
