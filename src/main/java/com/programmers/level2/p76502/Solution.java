package com.programmers.level2.p76502;

import java.util.*;

public class Solution {
    public int solution(String s) {
        int answer = 0;

        int n = s.length();
        s += s; // s의 원본을 하나 복사해서 붙임

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        A: for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            for (int j = i; j < i + n; j++) {
                char c = s.charAt(j);
                // 만약 닫힌 괄호가 아니라면
                if (!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    // 닫힌 괄호를 만났는데 스택이 비어 있거나 열린 괄호를 뽑을 수 없다면 올바른 괄호가 아님
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A; // 안쪽 for문 종료
                    }
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}
