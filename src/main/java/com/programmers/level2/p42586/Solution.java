package com.programmers.level2.p42586;

import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        int pre = (int) Math.ceil((100.0 - progresses[0]) / speeds[0]);
        int cnt = 1;

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < progresses.length; i++) {
            if (pre >= (int) Math.ceil((100.0 - progresses[i]) / speeds[i])) {
                cnt++;
            } else {
                result.add(cnt);
                pre = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
                cnt = 1;
            }
        }

        result.add(cnt);

        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}