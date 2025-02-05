package com.programmers.level0.p120902;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().solution("3 + 4");
    }

    public int solution(String my_string) {
        int answer = 0;

        String[] strArr = my_string.split(" ");

        Stack<Integer> numStk = new Stack<>();
        Stack<String> operStk = new Stack<>();

        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i].equals("+") || strArr[i].equals("-")) {
                operStk.push(strArr[i]);
            } else {
                numStk.push(Integer.parseInt(strArr[i]));
            }
        }

        answer += Integer.parseInt(strArr[0]);

        while (!numStk.isEmpty()) {
            String oper = operStk.pop();
            int num = numStk.pop();

            if (oper.equals("+")) {
                answer += num;
            } else {
                answer -= num;
            }
        }

        return answer;
    }
}
