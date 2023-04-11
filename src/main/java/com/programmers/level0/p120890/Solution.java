package com.programmers.level0.p120890;


import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int minValue = 0;

        Arrays.sort(array); // 오름 차순 정렬

        for (int i : array) {
            if (Math.abs(n - i) == 0) { // 차이가 0이면 뒤는 볼 것도 없이 제일 작은 거리
                return i; // 바로 그 수를 리턴한다.
            } else if (minValue > Math.abs(n - i) || minValue == 0) {
                minValue = Math.abs(n - i);
                answer = i;
            }
        }
        return answer;
    }
}