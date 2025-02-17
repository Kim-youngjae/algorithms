package com.programmers.level1.p42576;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().solution(new String[] { "mislav", "stanko", "mislav", "ana" },
                new String[] { "stanko", "ana", "mislav" });
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> compMap = new HashMap<>();

        for (String name : completion) {
            compMap.put(name, compMap.getOrDefault(name, 0) + 1);
        }

        for (String name : participant) {

            if (compMap.containsKey(name) && compMap.get(name) > 0) {
                compMap.put(name, compMap.get(name) - 1);
            } else {
                answer = name;
                break;
            }
        }

        return answer;
    }
}
