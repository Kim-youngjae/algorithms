package com.programmers.level1.p12982;

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d); // 오름 차순으로 정렬

        int sum = 0; // 지원할 수 있는 금액을 계산
        int cnt = 0; // 몇 개의 부서에 지원이 가능한지 카운트

        for (int i : d) {
            sum += i; // 지원할 수 있는 금액을 더한뒤
            if (sum <= budget) { // 예산을 넘어가는지 확인
                cnt ++; // 넘어가지 않는다면 카운트
            } else {
                break; // 넘어간다면 중지
            }
        }
        return cnt; // 총 지원할 수 있는 부서의 수를 반환
    }
}