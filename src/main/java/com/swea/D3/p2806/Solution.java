package com.swea.D3.p2806;

import java.io.*;

public class Solution {

    static int[] arr;
    static int N, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N];
            count = 0;
            set(0);

            bw.write("#" + t + " " + count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void set(int depth) {
        if (depth == N) {
            count++;
            return;
        } else {
            for (int i = 0; i < N; i++) {
                arr[depth] = i;
                if (canSet(depth)) {
                    set(depth + 1);
                }
            }
        }
    }

    private static boolean canSet(int col) {
        for (int i = 0; i < col; i++) {
            // 같은 행에 위치한 경우
            if (arr[i] == arr[col] || Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
