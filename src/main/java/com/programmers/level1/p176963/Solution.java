package com.programmers.level1.p176963;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int row = photo.length;

        answer = new int[photo.length];

        int sum = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                if (map.get(photo[i][j]) != null) {
                    sum += map.get(photo[i][j]);
                }
            }
            answer[i] = sum;
            sum = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, new String[][]{{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}});
    }
}
