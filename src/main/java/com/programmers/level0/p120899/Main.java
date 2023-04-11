package com.programmers.level0.p120899;

public class Main {
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120899

class Solution {
    public int[] solution(int[] array) {

        int max = array[0];
        int maxIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i]; // 바꿔주기
                maxIndex = i;
            }
        }
        return new int[]{max, maxIndex};
    }
}