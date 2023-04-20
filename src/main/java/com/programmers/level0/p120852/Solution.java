package com.programmers.level0.p120852;

import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};

        // 소인수만 담으면 된다.
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
        }

        if (n != 1) {
            set.add(n);
        }

        set.toArray();

        answer = new int[set.size()];
        int idx = 0;

        for (int i : set) {
            answer[idx++] = i;
        }
        return answer;
    }
}
