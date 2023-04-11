package com.programmers.level0.p120892;

public class Main {
}

class Solution {
    public String solution(String cipher, int code) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        for (int i = code; i <= cipher.length(); i += code) {
            sb.append(cipher.charAt(i - 1));
        }

        answer = sb.toString();

        return answer;
    }
}
