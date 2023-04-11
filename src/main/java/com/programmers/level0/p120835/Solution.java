package com.programmers.level0.p120835;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] emergency) {
        int[] emergencyAsc = new int[emergency.length];
        int[] rank = new int[emergency.length];

        for (int i = 0; i < emergency.length; i++) {
            emergencyAsc[i] = emergency[i];
        }

        Arrays.sort(emergencyAsc);

        for (int i = 0; i < emergency.length; i++) {
            for (int j = 0; j < emergency.length; j++) {
                if (emergencyAsc[i] == emergency[j]) {
                    rank[j] = emergency.length - i;
                }
            }
        }

        return rank;
    }
}