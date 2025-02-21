package com.programmers.level1.p12925;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        String numPart = "";

        if (s.charAt(0) == '-') {
            numPart = s.substring(1);
            answer = -1 * Integer.parseInt(numPart);
        } else if (s.charAt(0) == '+') {
            numPart = s.substring(1);
            answer = Integer.parseInt(numPart);
        } else {
            answer = Integer.parseInt(s);
        }

        return answer;
    }
}
