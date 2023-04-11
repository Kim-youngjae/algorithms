package com.programmers.level1.p86491;

class Solution {
    public static void main(String[] args) {
        new Solution().solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
    }

    public int solution(int[][] sizes) {
        int answer = 0;

        int maxValue = Integer.MIN_VALUE; // 가장 긴 길이
        int minValue = Integer.MIN_VALUE; // 가장 짧은 길이

        for (int i = 0; i < sizes.length; i++) {
            int len1 = sizes[i][0];
            int len2 = sizes[i][1];

            if (len1 > len2) {
                if (len1 > maxValue) {
                    maxValue = len1;
                }
                if (len2 > minValue) {
                    minValue = len2;
                }
            } else {
                if (len2 > maxValue) {
                    maxValue = len2;
                }
                if (len1 > minValue) {
                    minValue = len1;
                }
            }
            System.out.printf("현재 max: %d , min: %d\n", maxValue, minValue);
        }

        answer = maxValue * minValue;
        System.out.println(answer);
        return answer;
    }
}