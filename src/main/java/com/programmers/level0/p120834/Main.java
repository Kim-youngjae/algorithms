package com.programmers.level0.p120834;

public class Main {
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120834

class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();

        String ageStr = String.valueOf(age);
        for (int i = 0; i < ageStr.length(); i++) {
            char a = (char) (ageStr.charAt(i) + '1');
            sb.append(a);
        }

        return sb.toString();
    }
}