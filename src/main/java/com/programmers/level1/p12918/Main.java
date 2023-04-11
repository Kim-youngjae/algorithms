package com.programmers.level1.p12918;

// 문자열 다루기 기본
public class Main {
}

// https://school.programmers.co.kr/learn/courses/30/lessons/12918

class Solution {
    public boolean solution(String s) {
        boolean answer = true;

        if (!(s.length() == 4 || s.length() == 6)) {
            return false;
        }

        char[] strToChars = s.toCharArray();

        for (char c : strToChars) {
            if (!Character.isDigit(c)) {
                return false;
            }
            if (Character.getNumericValue(c) >= 1 || Character.getNumericValue(c) <= 8) {
               continue;
            }
        }

        return answer;
    }
}