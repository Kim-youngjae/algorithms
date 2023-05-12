package com.programmers.level2.p64065;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        new Solution().solution("{{20,111},{111}}");
    }

    public int[] solution(String s) {
        int[] answer = {};

        // 배열을 다루기 위해 불필요한 것들을 제거
        s = s.substring(2, s.length() - 2);
        String[] sBits = s.split("},\\{");

        // 추출한 문자열을 저장하기 위한 map
        Map<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < sBits.length; i++) {
            String[] bits = sBits[i].split(","); // ,을 기준으로 분리

            int[] intBits = new int[bits.length];

            for (int j = 0; j < bits.length; j++) {
                intBits[j] = Integer.parseInt(bits[j]); // 해당 문자열 원소들을 int[]에 담기
            }

            map.put(bits.length, intBits); // ,를 기준으로 분리한 문자열의 길이를 키, 해당 배열 원소를 값으로 가시는 map 생성
        }

        Set<Integer> set = new LinkedHashSet<>();

        for (int i = 1; i <= map.size(); i++) {
            int[] intBits = map.get(i);

            for (int j = 0; j < map.get(i).length; j++) { // 키에 해당하는 값 -> int[]
                set.add(intBits[j]); // set에 넣기 -> 1, 2, 3,,,
            }
        }

        answer = new int[set.size()]; // 결과를 담을 배열

        Object[] objects = set.toArray();

        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) objects[i];
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}