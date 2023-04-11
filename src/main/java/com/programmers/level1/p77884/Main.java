package com.programmers.level1.p77884;

public class Main {
}

//https://school.programmers.co.kr/learn/courses/30/lessons/77884

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        // left -> right 까지 해당 약수의 갯수가 짝수면 더하기, 홀수면 빼기
        for (int i = left; i <= right; i++) {
            // 갯수를 카운트할 변수
            int cnt = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) { //나누어 떨어지면
                    cnt++;
                }
            }

            // 약수 갯수가 홀수이면
            if (cnt % 2 != 0) {
                answer -= i; // 빼기
            } else {
                answer += i;
            }

        }

        return answer;
    }
}