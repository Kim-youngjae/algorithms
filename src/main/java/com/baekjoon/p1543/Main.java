package com.baekjoon.p1543;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentences = sc.nextLine();
        String pattern = sc.nextLine();

        int lastIndex = 0;
        int cnt = 0;

        while (lastIndex < sentences.length()) {

            int newIndex = sentences.indexOf(pattern, lastIndex); // 마지막 인덱스부터 시작

            if (newIndex == -1) {
                // 없으면 0 리턴하고 종료
                break;
            }

            if (newIndex >= lastIndex) { // 찾은 인덱스가 마지막 인덱스보다 크면
                lastIndex = newIndex + pattern.length(); // 갱신
                cnt++; // 횟수 카운트
            } else {
                lastIndex = newIndex + pattern.length();
            }
        }

        System.out.println(cnt);
    }
}
