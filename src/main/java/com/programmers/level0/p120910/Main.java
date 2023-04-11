package com.programmers.level0.p120910;

public class Main {
    public static void main(String[] args) {
    }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120910

class Solution {
    public int solution(int n, int t) {
        int answer = n;

        for (int i = 0; i < t; i++) {
            answer += n * Math.pow(2, i);
        }

        return answer;
    }
}