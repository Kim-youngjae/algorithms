package com.swea.D1.p1545;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        list.sort(Comparator.naturalOrder());

        int mid = N / 2;

        System.out.println(list.get(mid));

        sc.close();
    }
}
