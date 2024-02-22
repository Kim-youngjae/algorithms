package com.baekjoon.p7795;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            a = new int[n];
            b = new int[m];

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(b);
            int res = 0;

            for (int n : a) {
                int s = 0;
                int e = m - 1;
                int cnt = 0;

                while (s <= e) {
                    int mid = (s + e) / 2;
                    if (b[mid] < n) {
                        s = mid + 1;
                        cnt = mid + 1;
                    } else {
                        e = mid - 1;
                    }
                }
                res += cnt;
            }

            sb.append(res + "\n");
        }
        System.out.println(sb);
    }
}