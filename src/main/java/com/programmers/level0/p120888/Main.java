package com.programmers.level0.p120888;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120888

class Solution {
    public String solution(String my_string) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);

            // 저장할 리스트에 문자를 포함되어 있지 않으면 리스트에 추가
            if (!list.contains(String.valueOf(c))) {
                list.add(String.valueOf(c));
            }
        }

        for (String s : list) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("people"));
        System.out.println(new Solution().solution("We are the world"));
    }
}
