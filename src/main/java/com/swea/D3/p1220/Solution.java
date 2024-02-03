package com.swea.D3.p1220;

import java.io.*;
import java.util.*;

public class Solution {
    static int result, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t = 1; t <= 10; t++) {
            bw.write("#" + t + " ");
            n = Integer.parseInt(br.readLine());

            int[][] table = new int[n][n];

            // 초기화
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = 0;
            checkDeadLock(table);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void checkDeadLock(int[][] table) {
        for (int i = 0; i < n; i++) {
            StringBuffer sbf = new StringBuffer();

            for (int j = 0; j < n; j++) {
                if (table[j][i] == 1 || table[j][i] == 2) {
                    sbf.append(table[j][i]);
                }
            }

            String str = sbf.toString();

            // "12"(교착 기준)의 갯수를 세기
            for (int k = 0; k < str.length() - 1; k++) {
                if (str.charAt(k) - '0' == 1 && str.charAt(k + 1) - '0' == 2) {
                    result++;
                }
            }
        }
    }
}
