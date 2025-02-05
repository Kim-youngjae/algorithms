package com.programmers.level0.p120843;

public class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;

        // 배열 길이가 2 * k개는 있어야 한다.
        int minLen = 2 * k;
        // 새 배열의 길이가 될 변수
        int newLen = numbers.length;

        // 최소 길이 보다 작다면 배열 길이를 늘려서 설정해준다.
        while (newLen < minLen) {
            newLen += newLen;
        }

        // 새 배열 선언
        int[] newArr = new int[newLen];

        for (int i = 0; i < newLen; i++) {
            newArr[i] = numbers[i % numbers.length];
        }

        answer = newArr[minLen - 2];

        return answer;
    }
}
