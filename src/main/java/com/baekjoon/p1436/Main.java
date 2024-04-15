package com.baekjoon.p1436;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int movie = 666;

        while (N > 0) { // N 번째 영화를 찾을 때 까지 반복

            String str = String.valueOf(movie);
            char[] endNum = { '6', '6', '6' };

            for (int i = 0; i < str.length() - 2; i++) { // 변환한 영화 번호에 666이 차례로 포함되어 있는지 검사
                if (endNum[0] == str.charAt(i) && endNum[1] == str.charAt(i + 1) && endNum[2] == str.charAt(i + 2)) {
                    N--;
                    break;
                }
            }

            movie++; // 없으면 그 다음 영화로
        }

        System.out.println(movie - 1);
        sc.close();
    }
}
