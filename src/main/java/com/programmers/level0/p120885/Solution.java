package com.programmers.level0.p120885;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("10", "11"));
    }

    public String solution(String bin1, String bin2) {
        String answer = "";

        int num1 = Integer.parseInt(bin1, 2); // 2진수로 변환
        int num2 = Integer.parseInt(bin2, 2);
        int sum = num1 + num2;
        answer = Integer.toBinaryString(sum); // 10진수로 변환할 때
        return answer;
    }
}