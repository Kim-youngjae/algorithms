package com.programmers.level1.p68935;

class Solution {
    public int solution(int n) {
        int answer = 0;

        String ternary = Integer.toString(n, 3);

        int len = ternary.length();

        String reversedNum = "";

        for (int i = 0; i < len; i++) { // 뒤집기
            reversedNum += String.valueOf(ternary.charAt(len -  i - 1));
        }

        answer = Integer.parseInt(reversedNum, 3);  // 3진수 -> 10진수로 바꿀 때 그냥 3을 넣기
        return answer;
    }
}