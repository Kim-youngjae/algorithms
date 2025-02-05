package com.programmers.level2.p42584;

import java.util.*;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};

        int n = prices.length;

        answer = new int[n];
        Stack<Integer> stk = new Stack<>();
        stk.push(0);

        for (int i = 1; i < n; i++) {

            // 현재 가격이 직전의 가격보다 낮으면 stk에서 pop
            while (!stk.isEmpty() && prices[stk.peek()] > prices[i]) {
                int prevIdx = stk.pop();

                answer[prevIdx] = i - prevIdx;
            }

            stk.push(i);
        }

        while (!stk.isEmpty()) {
            int j = stk.pop();

            answer[j] = n - j - 1;
        }

        return answer;
    }
}
