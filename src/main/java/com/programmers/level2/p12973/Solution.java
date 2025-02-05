package com.programmers.level2.p12973;

import java.util.*;

public class Solution {
    public int solution(String s) {
        int answer = 0;

        int n = s.length();

        char[] arr = s.toCharArray();
        Stack<Character> stk = new Stack<>();

        stk.push(arr[0]);

        for (int i = 1; i < n; i++) {

            if (!stk.isEmpty() && stk.peek() == arr[i]) {
                stk.pop();
            } else {
                stk.push(arr[i]);
            }
        }

        if (stk.isEmpty())
            answer = 1;

        return answer;
    }
}
