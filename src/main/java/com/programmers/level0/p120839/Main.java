package com.programmers.level0.p120839;

public class Main {
    public static void main(String[] args) {
    }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120839

class Solution {
    // 가위 = 2, 바위 = 0, 보 = 5

    public String solution(String rsp) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rsp.length(); i++) {
            if (rsp.charAt(i) == '2') {
                sb.append("0");
            } else if (rsp.charAt(i) == '0') {
                sb.append("5");
            } else if (rsp.charAt(i) == '5'){
                sb.append("2");
            }
        }

        answer = sb.toString();

        return answer;
    }
}