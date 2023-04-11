package com.programmers.level0.p120846;

public class Main {
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120846

class Solution {
    public int solution(int n) {
        int answer = 0;

        // n이하 합성 수 4가 합성수 중 가장 작음 4 ~ n
        for (int i = 4; i <= n; i++) {
            int cnt = 0; // 약수의 갯수
            for (int j = 1; j <= i; j++) {
                // 약수이면 카운트
                if (i % j == 0) {
                    cnt++;
                }
            }
            if (cnt > 2) { // 약수 갯수가 3이상이면 합성수
                answer++;
            }
        }

        return answer;
    }
}