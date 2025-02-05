package com.swea.D3.p1493;

import java.io.*;
import java.util.*;

class Point {
    int r;
    int c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Solution {
    static int[][] m;
    static Map<Integer, Point> map = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        m = new int[150 + 1][150 + 1];

        m[1][1] = 1;
        map.put(1, new Point(1, 1));

        for (int i = 1; i <= 100; i++) {
            m[i][1] = m[i - 1][1] + (i);
            int num = i;

            for (int j = 2; j <= 100; j++) {
                m[i][j] = m[i][j - 1] + (num++);
                map.put(m[i][j], new Point(i, j));
            }
        }

        Point x = map.get(3);

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            Point P = map.get(p);
            Point Q = map.get(q);

            int ans = m[P.r + Q.r][P.c + P.c];
            sb.append(ans + "\n");
        }

    }
}
