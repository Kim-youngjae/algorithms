package com.programmers.level1.p178871;

import java.util.HashMap;

class Solution {

    static String[] answer;

    public String[] solution(String[] players, String[] callings) {
        answer = new String[players.length];

        HashMap<String, Integer> nameKeyMap = new HashMap<>(players.length);
        HashMap<Integer, String> rankKeyMap = new HashMap<>(players.length);

        for (int i = 0; i < players.length; i++) {
            nameKeyMap.put(players[i], i);
            rankKeyMap.put(i, players[i]);
        }

        for (String name : callings) {
            // 해설이 부른 선수 이름과 현재 등수
            int currRank = nameKeyMap.get(name);
            String currName = rankKeyMap.get(currRank);

            // 추월할 선수
            String target = rankKeyMap.get(currRank - 1);

            // swap
            nameKeyMap.put(currName, currRank - 1);
            nameKeyMap.put(target, currRank);

            rankKeyMap.put(currRank - 1, currName);
            rankKeyMap.put(currRank, target);
        }

        // 정답에 넣기
        for (int i = 0; i < players.length; i++) {
            answer[i] = rankKeyMap.get(i);
        }

        return answer;
    }
}
