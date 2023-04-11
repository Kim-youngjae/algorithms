package com.programmers.level0.p120905;

import java.util.ArrayList;

public class Main {
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120905

class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] answer;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i : numlist) {
            if (i % n == 0) {
                arrayList.add(i);
            }
        }

        answer = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }
}