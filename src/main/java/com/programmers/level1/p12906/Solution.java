package com.programmers.level1.p12906;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        Queue<Integer> q = new LinkedList<>(); // 연속을 제거한 하나의 값만 저장

        int temp = arr[0];
        q.add(temp);

        for (int i = 1; i < arr.length; i++) {
            if (temp != arr[i]) {
                // 현재 연속 되는 수와 다른 값이면
                temp = arr[i];
                q.add(temp); // 다른 값을 저장
            }
        }

        int idx = 0;
        answer = new int[q.size()];

        while (!q.isEmpty()) {
            answer[idx++] = q.poll();
        }

        return answer;
    }
}