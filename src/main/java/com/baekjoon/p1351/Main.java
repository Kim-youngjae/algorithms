package com.baekjoon.p1351;

import java.util.*;

public class Main {
    static Map<Long, Long> A;
    static long N;
    static int P;
    static int Q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextLong();
        P = sc.nextInt();
        Q = sc.nextInt();

        A = new HashMap<>();

        System.out.println(sequence(N));
        sc.close();
    }

    private static long sequence(long val) {
        if (val == 0) {
            return 1;
        }

        if (A.containsKey(val)) {
            return A.get(val);
        }

        long a = (long) Math.floor(val / P);
        long b = (long) Math.floor(val / Q);

        A.put(val, sequence(a) + sequence(b));
        return A.get(val);
    }
}
