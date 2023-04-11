package com.programmers.level0.p120906;

public class Main {
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120906

class Solution {

    public int solution(int n) {
        return (n + "") // 123 -> "123"
                .chars() // -> "123" -> s[49, 50, 51]
                .map(e -> Character.getNumericValue(e)) // s[49, 50, 51] -> IntStream[1, 2, 3]
                .sum();
    }



    public int solutionV2(int n) {
        String nToStr = String.valueOf(n);
        int sum = 0;

        for (int i = 0; i < nToStr.length(); i++) {
//            sum += Integer.valueOf(nToStr.charAt(i) - '0');
            sum += Character.getNumericValue(nToStr.charAt(i));
        }

        return sum;
    }
}
