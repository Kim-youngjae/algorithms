package com.programmers.level2.p42586;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> q = new LinkedList<>();

        List<Integer> result = new ArrayList<>(); // 정답을 저장할 리스트

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];

            q.add((int) Math.ceil((100.0 - progress) / speed));
        }


        while (!q.isEmpty()) {
            int ahead = q.poll();
            int cnt = 1;

            while (!q.isEmpty() && ahead >= q.peek()) {
                q.poll();
                cnt++;
            }

            result.add(cnt);
        }

        answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}