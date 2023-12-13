package com.baekjoon.p2110;

import java.util.*;

public class Main {

    static int[] house;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt(); // 설치해야 할 최소 공유기 개수

        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = sc.nextInt();
        }

        Arrays.sort(house);

        int start = 1;
        int end = house[N - 1] - house[0] + 1;

        long maxDistence = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (installCount(mid) < C) {
                end = mid - 1;
            } else {
                start = mid + 1;
                maxDistence = start;
            }
        }

        System.out.println(maxDistence - 1);
        sc.close();
    }

    private static int installCount(int mid) {
        int count = 1;
        int lastInstall = house[0];

        for (int i = 1; i < house.length; i++) {
            int position = house[i];

            if (position - lastInstall >= mid) {
                count++;
                lastInstall = position;
            }
        }

        return count;
    }
}
