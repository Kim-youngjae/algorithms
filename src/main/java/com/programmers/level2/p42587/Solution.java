package com.programmers.level2.p42587;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    static int cnt = 1;
    static int maxValue;

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Procedure> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) { // 큐에 값 집어넣어 주기
            q.add(new Procedure(i, priorities[i]));
        }

        Arrays.sort(priorities);

        maxValue = priorities[priorities.length - 1]; // 제일 큰 값 찾아주기

        while (!q.isEmpty()) {
            // 만약 큐의 중요도가 가장 크다면?
            Procedure current = q.poll();

            if (current.index == location && current.priority >= maxValue) {
                answer = cnt++;
                break;
            }

            if (current.priority < maxValue) {
                q.add(current); // 다시 큐안에 넣기
            } else {
                maxValue = q.peek().priority;
                cnt++;
            }

        }

        return answer;
    }
}

class Procedure {
    int index;
    int priority;

    public Procedure(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}