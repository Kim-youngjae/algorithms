package com.baekjoon.p1074;

import java.io.*;
import java.util.*;

public class Main {
    static int N, R, C, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        zSearch(size, R, C, 0);
        System.out.println(ans);
    }

    static void zSearch(int size, int r, int c, int cnt) {
        if (size == 1) {
            ans = cnt;
            return;
        }
        if (r < size / 2 && c < size / 2) { // 1사분면
            zSearch(size / 2, r, c, cnt);
        } else if (r < size / 2 && c >= size / 2) { // 2사분면
            cnt += (size * size) / 4;
            zSearch(size / 2, r, c - size / 2, cnt);
        } else if (r >= size / 2 && c < size / 2) { // 3 사분면
            cnt += (size * size) / 4 * 2;
            zSearch(size / 2, r - size / 2, c, cnt);
        } else { // 4 사분면
            cnt += (size * size) / 4 * 3;
            zSearch(size / 2, r - size / 2, c - size / 2, cnt);
        }
    }
}
