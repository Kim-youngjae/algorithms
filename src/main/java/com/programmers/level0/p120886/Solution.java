package com.programmers.level0.p120886;

//https://school.programmers.co.kr/learn/courses/30/lessons/120886

import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        char[] beforeArr = new char[before.length() + 1];
        char[] afterArr = new char[after.length() + 1];

        for (int i = 0; i < before.length(); i++) {
            beforeArr[i] = before.charAt(i);
            afterArr[i] = after.charAt(i);
        }

        Arrays.sort(beforeArr);
        Arrays.sort(afterArr);

        return Arrays.equals(beforeArr, afterArr) ? 1 : 0;
    }

    public static void main(String[] args) {
        int solution = new Solution().solution("olleh", "hello");

        System.out.println(solution);
    }
}