package com.programmers.level2.p12909;

import java.util.Stack;

class Solution {
    static Stack<Character> stack = new Stack<>();
    
    boolean solution(String s) {
        boolean answer = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.isEmpty()) {
                return false; // 닫힌 괄호가 남았는데 stack 이 비었으면 올바르지 않은 괄호
            } else if (s.charAt(i) == '(') {
                stack.push(s.charAt(i)); // 열린 괄호는 스택에 푸시
            } else if (s.charAt(i) == ')' && !stack.isEmpty()) {
                // 닫힌 괄호를 만났고 스택이 비어있지 않다면
                while (!stack.isEmpty()) {
                    Character data = stack.pop();
                    if (data == '(') {
                        break; // 열린 괄호를 만나면 반복문 종료
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}
