package com.programmers.level0.p120904;

public class Main {

}

//https://school.programmers.co.kr/learn/courses/30/lessons/120904

class Solution {
    public int solution(int num, int k) {
        int answer = -1;

        String numStr = num + "";
        // k 가 몇번쨰 자리에 있는지 리턴해야함
        for (int i = 0; i < numStr.length(); i++) {
            if (Character.getNumericValue(numStr.charAt(i)) == k) {
                answer = i + 1;
                break; // 찾으면 종료
            }
        }

        return answer;
    }

    public int solution2(int num, int k) {
        int answer = -1;

        String numStr = num + "";
        // k 가 몇번째 자리에 있는지 리턴해야함
        answer = numStr.indexOf(String.valueOf(k)); // 파라미터로 찾고자하는 문자를 넣어야 함

        return answer + 1;
    }
}