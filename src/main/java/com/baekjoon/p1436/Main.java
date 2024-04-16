package com.baekjoon.p1436;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int movie = 666;

        while (N > 0) { // N 번째 영화를 찾을 때 까지 반복

            String str = String.valueOf(movie);

            if (str.contains("666")) {
                N--;
                movie++;
            } else {
                movie++;
            }
        }

        System.out.println(movie - 1);
        sc.close();
    }
}
