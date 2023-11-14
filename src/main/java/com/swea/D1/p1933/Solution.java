package com.swea.D1.p1933;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        int N = sc.nextInt();
        int sqrt = (int) Math.sqrt(N);

        for (int i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                if (Math.pow(i, 2) == N) {
                    list.add(i);
                } else {
                    list.add(i);
                    list.add(N / i);
                }
            }
        }

        list.sort(Comparator.naturalOrder());

        for (int i : list) {
            System.out.print(i + " ");
        }

        sc.close();
    }
}
