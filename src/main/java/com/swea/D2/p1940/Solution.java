package com.swea.D2.p1940;

import java.util.*;

public class Solution {
    static int d = 0; // 이동 거리
    static int v = 0; // 속력

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            d = 0;
            v = 0;

            for (int i = 0; i < N; i++) {
                int c1 = sc.nextInt();
                int c2;

                switch (c1) {
                    case 0:
                        v += 0;
                        break;
                    case 1: // 가속
                        c2 = sc.nextInt();
                        v += c2;
                        break;
                    case 2:
                        c2 = sc.nextInt();
                        v -= c2;
                        if (v < 0)
                            v = 0;
                        break;
                }

                d += v;
            }

            sb.append("#" + t + " " + d + "\n");
        }

        System.out.print(sb);
        sc.close();
    }
}
