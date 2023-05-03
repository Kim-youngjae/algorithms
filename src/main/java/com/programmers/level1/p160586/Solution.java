package com.programmers.level1.p160586;

import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {

        HashMap<Character, Integer> keyboard = new HashMap<>(); // 버튼마다 최소로 누르는 횟수를 저장할 map

        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);

                if (!keyboard.containsKey(c) || i < keyboard.get(c)) { // map에 key를 가지고 있지 않거나 i(버튼을 누르기 위해 눌려야 할 횟수)가 원래 저장된 수보다 적을 때
                    keyboard.put(c, i + 1); // 그 수가 제일 최소로 버튼을 누르는 경우라서 더해줌
                }
            }
        }

        int[] result = new int[targets.length]; // 결과를 저장할 배열

        for (int i = 0; i < targets.length; i++) {
            int count = 0; // 횟수를 셀 count 변수

            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);

                if (keyboard.containsKey(c)) {
                    count += keyboard.get(c); // 누를 수 있는 버튼이 있고 값이 있으면 더해줌
                } else {
                    count = 0; // 없다는 뜻은 그 문자를 만들지 못함
                    break;
                }
            }
            result[i] = count == 0 ? -1 : count; // 총 횟수가 0이면 -1 저장, 아니면 횟수 저장
        }

        return result;
    }
}