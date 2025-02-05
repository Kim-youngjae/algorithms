package com.programmers.level0.p120913;

public class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = {};

        int originLen = my_str.length();
        int ansLen = 0;
        if (originLen % n == 0) {
            ansLen = originLen / n;
        } else {
            ansLen = originLen / n + 1;
        }

        answer = new String[ansLen];

        for (int i = 0; i < ansLen; i++) {
            int start = i * n;
            int end = Math.min(start + n, originLen);
            answer[i] = my_str.substring(start, end);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("abc1Addfggg4556b", 6).toString());
    }
}
