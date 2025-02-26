package com.programmers.level1.p42840;

import java.util.*;

public class Solution {

    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] one = { 1, 2, 3, 4, 5 }; // 1번 수포자 찍는 패턴
        int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 }; // 2번 수포자 찍는 패턴
        int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 3번 수포자 찍는 패턴

        int correct1 = 0, correct2 = 0, correct3 = 0;

        for (int i = 0; i < answers.length; i++) {
            int indx1 = i % one.length;
            int indx2 = i % two.length;
            int indx3 = i % three.length;

            if (answers[i] == one[indx1]) {
                correct1++;
            }
            if (answers[i] == two[indx2]) {
                correct2++;
            }
            if (answers[i] == three[indx3]) {
                correct3++;
            }
        }

        // 가장 높은 정답 개수 구하기
        int maxAnsCnt = Math.max(correct1, Math.max(correct2, correct3));
        List<Integer> result = new ArrayList<>();

        if (correct1 == maxAnsCnt) {
            result.add(1);
        }
        if (correct2 == maxAnsCnt) {
            result.add(2);
        }
        if (correct3 == maxAnsCnt) {
            result.add(3);
        }

        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
