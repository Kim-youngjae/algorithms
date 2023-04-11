package com.programmers.level0.p120893;

public class Main {
    public static void main(String[] args) {
//        new Solution().solution("a");
    }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120893

class Solution {
    public String solution(String my_string) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(String.valueOf(c).toLowerCase());
            } else {
                sb.append(String.valueOf(c).toUpperCase());
            }
        }

        answer = sb.toString();

        return answer;
    }
}