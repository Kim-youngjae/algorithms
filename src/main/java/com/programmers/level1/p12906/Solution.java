package com.programmers.level1.p12906;

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};

        Stack<Integer> s = new Stack<>();

        for (int i : arr) {

            if (s.isEmpty()) { // 스택이 비어 있다면 push
                s.push(i);
                continue;
            }

            if (!s.isEmpty() && s.peek() == i) {
                // 제일 위의 값과 현재 i를 비교 해서 연속된 숫자인지 확인
                // 연속된 숫자라면 아무것도 하지 않고 다음 반복문으로 넘어가기
                continue;
            } else {
                s.push(i);
            }
        }

        answer = new int[s.size()];
        for (int i = 0; i < s.size(); i++) {
            answer[i] = s.get(i);
        }

        return answer;
    }
}