package com.programmers.level1.p178871;

import java.util.HashMap;

class Solution {

    static String[] answer;

    public String[] solution(String[] players, String[] callings) {
        answer = new String[players.length];

        HashMap<String, Integer> map = new HashMap<>(players.length);

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
            answer[i] = players[i];
        }

        for (String name : callings) {
            int idx = map.get(name);
            int changedIdx = swap(idx);
            map.put(name, changedIdx);
        }

        return answer;
    }

    public static int swap(int n) {
        String temp = answer[n - 1];
        answer[n - 1] = answer[n];
        answer[n] = temp;
        return n - 1;
    }
}
