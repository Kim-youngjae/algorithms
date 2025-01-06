package com.programmers.level2.p42587;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
        System.out.println(new Solution().solution(new int[] { 2, 1, 3, 2 }, 2));
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
        }

        int cnt = 0;

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) { // 원래 순서를 위해 for 반복문으로 탐색
                if (priorities[i] == pq.peek()) { // 꺼낸 우선 순위와 일치하면 꺼내야 한다.
                    pq.poll();
                    answer++;

                    if (location == i) { // 내가 처음 찾고자한 위치의 원소와 일치한다면
                        // pq를 비우면 while문에 걸리지 않아 while문까지 종료된다.
                        pq.clear();
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
