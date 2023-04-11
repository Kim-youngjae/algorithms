package com.programmers.level0.p120896;

import java.util.*;

class Solution {
    //    https://school.programmers.co.kr/learn/courses/30/lessons/120896
    public static void main(String[] args) {
        System.out.println(new Solution().solution("abcabcadc"));


    }

    public String solution(String s) {

        ArrayList<String> answer = new ArrayList<>();
        String result = "";

        int[] counts = new int[s.length()];
        String[] bits = s.split("");

        for (String str : bits) {
            for (int i = 0; i < bits.length; i++) {
                if (String.valueOf(s.charAt(i)).equals(str)) {
                    counts[i]++;
                }
            }
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 1) {
                answer.add(bits[i]);
            }
        }

        if (answer.isEmpty()) {
            return "";
        } else {
            Collections.sort(answer);

            for (int i = 0; i < answer.size(); i++) {
                result += answer.get(i);
            }

            return result;
        }
    }
}