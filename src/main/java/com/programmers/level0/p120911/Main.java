package com.programmers.level0.p120911;

import java.util.Arrays;

public class Main {
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120911

class Solution {
    public String solution(String my_string) {
        String answer = "";

        //소문자로 바꾸기
        String[] bits = my_string.toLowerCase().split("");

        StringBuilder sb = new StringBuilder();

        // 알파벳 순서대로 정렬
        Arrays.sort(bits);

        for (String s : bits) {
            sb.append(s);
        }

        answer = sb.toString();

        return answer;
    }
}