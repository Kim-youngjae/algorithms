package com.programmers.level1.p68644;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int len = numbers.length;

        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                hs.add(numbers[i] + numbers[j]);
            }
        }

        answer = new int[hs.size()];

        Iterator<Integer> iter = hs.iterator();

        for (int i = 0; i < answer.length; i++) {
            answer[i] = iter.next();
        }

        Arrays.sort(answer);

        return answer;
    }
}
