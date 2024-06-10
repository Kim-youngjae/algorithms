package com.baekjoon.p1254;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int idx = 0;
        StringBuffer str = new StringBuffer();
        StringBuffer addedStr = new StringBuffer();

        str.append(sc.next());

        while (true) {
            // 펠린드롬이 아니면 제일 앞의 단어를 추가
            if (!palindrom(str.toString() + addedStr.reverse())) {
                addedStr.reverse();
                addedStr.append(str.charAt(idx));
                idx++;
            } else {
                // 펠린드롬일 경우
                break;
            }
        }

        System.out.println(str.length() + addedStr.length());
        sc.close();
    }

    static boolean palindrom(String str) {
        int size = str.length();
        int mid = 0;

        if (size % 2 == 0) {
            mid = size / 2 + 1;
        } else {
            mid = size / 2;
        }

        for (int i = 0; i < mid; i++) {
            if (str.charAt(i) == str.charAt(size - i - 1)) {
                continue;
            }

            return false;
        }

        return true;
    }
}
