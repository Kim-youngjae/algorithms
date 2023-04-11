package com.programmers.level1.p12917;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
}

// https://school.programmers.co.kr/learn/courses/30/lessons/12917

class Solution {
    public String solution(String s) {
        String answer = "";
        List<Character> list = new ArrayList<>(s.length() + 1);
        for (char c : s.toCharArray()) {
            list.add(c);
        }

        Collections.sort(list, Collections.reverseOrder()); // sort(정렬할 컬렉션, 정렬기준)

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }

        answer = sb.toString();

        return answer;
    }
}