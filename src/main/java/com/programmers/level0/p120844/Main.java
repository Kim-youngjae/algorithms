package com.programmers.level0.p120844;

public class Main {
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120844

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];

        switch (direction) {
            case "right": // 오른쪽으로 한칸씩 이동
                //맨 마지막 원소는 따로 이동
                for (int i = numbers.length - 1; i >= 1; i--) {
                    swap(numbers, i, i - 1);
                }
                break;
            case "left":
                for (int i = 0; i < numbers.length - 1; i++) {
                    swap(numbers, i, i + 1);
                }
                break;
        }

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[i];
        }

        return answer;
    }

    void swap(int[] a, int i1, int i2) {
        int tmp = a[i1];
        a[i1] = a[i2];
        a[i2] = tmp;
    }
}