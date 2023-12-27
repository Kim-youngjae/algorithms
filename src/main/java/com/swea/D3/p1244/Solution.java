package com.swea.D3.p1244;

import java.io.*;
import java.util.*;

public class Solution {
    static String[] arr;
    static int cnt = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb1 = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String num = st.nextToken();
            cnt = Integer.parseInt(st.nextToken()); // 옮길 수 있는 횟수

            result = 0;
            arr = new String[num.length()];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Character.toString(num.charAt(i));
            }

            if (cnt > num.length()) {
                cnt = num.length();
            }

            dfs(0, 0);

            sb1.append("#" + t + " " + result + "\n");
        }

        System.out.println(sb1);
    }

    private static void dfs(int s, int e) {
        if (e == cnt) {
            StringBuilder sb2 = new StringBuilder();
            for (String str : arr) {
                sb2.append(str);
            }

            result = Math.max(result, Integer.parseInt(sb2.toString())); // 최대값 갱신 해주기
            return;
        }

        for (int i = s; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                dfs(i, e + 1);

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
