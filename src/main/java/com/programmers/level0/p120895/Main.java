package com.programmers.level0.p120895;

public class Main {
    public static void main(String[] args) {
        new Solution().solution("hello", 1, 2);
    }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120895
class Solution {

    public String solution(String my_string, int num1, int num2) {
        String answer = "";

        char[] chars = my_string.toCharArray();

        chars[num1] = my_string.charAt(num2);
        chars[num2] = my_string.charAt(num1);

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }

        answer = sb.toString();

        return answer;
    }
}