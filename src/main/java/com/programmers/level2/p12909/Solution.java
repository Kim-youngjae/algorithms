package com.programmers.level2.p12909;

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stk.push(c);
            } else {
                if (stk.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    stk.pop();
                }
            }
        }

        if (!stk.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}

// import java.util.Stack;

// class Solution {
// static Stack<Character> stack = new Stack<>();

// boolean solution(String s) {
// boolean answer = true;

// for (int i = 0; i < s.length(); i++) {
// if (s.charAt(i) == ')') {
// if (stack.isEmpty()) {
// return false; // 닫힌 괄호가 남았는데 stack 이 비었으면 올바르지 않은 괄호
// }
// stack.pop(); // 비어있지 않으면 여는 괄호 하나 꺼내기
// } else if (s.charAt(i) == '(') {
// stack.push(s.charAt(i)); // 열린 괄호는 스택에 푸시
// }
// }

// answer = stack.isEmpty();

// return answer;
// }
// }
