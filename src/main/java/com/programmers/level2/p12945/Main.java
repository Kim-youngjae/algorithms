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

class Solution2 {
    public int solution(int n) {
        int answer = 0;

        int prev = 0;
        int temp = 1;

        //temp = temp + prev

        for (int i = 2; i <= n; i++) {
            // 2부터 n 번째 까지
            answer = ((prev % 1234567) + (temp % 1234567)) % 1234567;
            prev = temp;
            temp = answer;
        }

        return answer;
    }
}