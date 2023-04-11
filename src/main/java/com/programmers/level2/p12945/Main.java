package com.programmers.level2.p12945;

public class Main {
}

//https://school.programmers.co.kr/learn/courses/30/lessons/12945

class Solution {
    public int solution(int n) {
        int answer = 0;

        int temp = 1;
        int prev = 0;

        for (int i = 2; i <= n; i++) {
            answer = (temp + prev) % 1234567;
            prev = temp % 1234567;
            temp = answer;

        }

        return answer;
    }
}
