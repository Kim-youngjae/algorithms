package com.baekjoon.p11726;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] tile = new int[1001];

        tile[1] = 1;
        tile[2] = 2;
        tile[3] = 3;

        for (int i = 4; i <= N; i++) {
            tile[i] = (tile[i - 2] + tile[i - 1]) % 10007;
        }

        System.out.println(tile[N]);
        sc.close();
    }
}
