package com.baekjoon.p1002;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2 && r1 == r2) { // 접점이 무한개일 때
                sb.append("-1\n");
            } else if (Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) > Math.pow((r1 + r2), 2)) {
                sb.append("0\n"); // 접접이 아예 없는 경우 (두 원이 떨어져 있는 경우)
            } else if (Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) < Math.pow((r1 - r2), 2)) {
                sb.append("0\n"); // 접접이 아예 없는 경우 (한 원 안에 다른 원이 있는 경우)
            } else if (Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) == Math.pow((r1 + r2), 2)) {
                sb.append("1\n"); // 외접한 경우
            } else if (Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) == Math.pow((r1 - r2), 2)) {
                sb.append("1\n"); // 내접한 경우
            } else {
                sb.append("2\n");
            }
        }
        System.out.println(sb);
    }
}
