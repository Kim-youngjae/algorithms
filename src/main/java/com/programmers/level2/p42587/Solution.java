package com.programmers.level2.p42587;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선 순위 큐, 내림 차순으로 정렬 기준을 가진다.

        for (int i = 0; i < priorities.length; i++) { // 큐에 값 집어넣어 주기
            pq.add(priorities[i]);
        }

        while (!pq.isEmpty()) { // 큐가 비어있지 않은 동안 반복
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) { // priorities[i] 의 값이 우선 순위 제일 높은 값이랑 같은지 비교
                    if (i == location) { // 우선 순위를 만족하고 해당 찾고자 하는 인덱스의 값과 일치한다면
                        answer += 1; // 마지막도 큐에서 나오는 것을 카운트 해줘야 한다.
                        return answer;
                    }
                    pq.poll(); // 알고자 하는 location 인덱스가 아니라면 (값만 같은 경우)
                    answer += 1; // 큐에서 값을 빼면 카운트
                }
            }
        }

        return answer;
    }
}