package com.programmers.level0.p120862;

import java.util.Arrays;

public class Main {
}
//https://school.programmers.co.kr/learn/courses/30/lessons/120862

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;

        // 정렬하고 제일 작은 두 요소 곱 vs 제일 큰 요소 두 요소의 곱 비교해서 더 큰 수
        Arrays.sort(numbers);

        int num1 = numbers[0] * numbers[1];
        int num2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];

        answer = Math.max(num1, num2);

        return answer;
    }
}