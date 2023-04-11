package com.programmers.level1.p82612;

// https://school.programmers.co.kr/learn/courses/30/lessons/82612

class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        int add = price;

        for (int i = 0; i < count; i++) { // count만큼 반복
            answer += add; // 원래 수 + 더 할 수
            add += price; // price씩 증가
        }

        answer = answer - money;
        if (answer > 0) {
            return answer;
        }

        return 0;
    }
}