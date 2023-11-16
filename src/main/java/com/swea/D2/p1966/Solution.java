package com.swea.D2.p1966;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                list.add(sc.nextInt());
            }

            list.sort(Comparator.naturalOrder());

            sb.append("#" + t);
            for (int i : list) {
                sb.append(" " + i);
            }
            sb.append("\n");
        }

        System.out.print(sb);
        sc.close();
    }
}
