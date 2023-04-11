package com.programmers.level0.p120848;

// https://school.programmers.co.kr/learn/courses/30/lessons/120848

class Solution {
    public int solution(int n) {
        int answer = 1;
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            answer *= i;
            if (answer <= n) {
                cnt += 1;
            } else {
                break;
            }
        }
        return cnt;
    }
}