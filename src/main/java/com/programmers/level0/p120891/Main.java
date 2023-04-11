package com.programmers.level0.p120891;

public class Main {
    public static void main(String[] args) {
//        for (int i = 1; i < 1000; i++) {
//            System.out.println(i + " = " + new Solution().solution(i));
//        }
        System.out.println(0 % 3);
    }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120891

class Solution {
    public int solution(int order) {
        int answer = 0; // 총 쳐야할 박수

        //숫자가 들어왔을 때 숫자에 3,6,9가 몇개 있는지 반환
        String order_str = String.valueOf(order);

        for (int i = 0; i < order_str.length(); i++) {
            int numericValue = Character.getNumericValue(order_str.charAt(i));
            if (numericValue % 3 == 0 && numericValue != 0) {
                answer++;
            }
        }

        return answer;
    }
}
