package com.programmers.level0.p120850;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        new Solution().solution("hi12392");
    }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120850

class Solution {
    public int[] solution(String my_string) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();

        char[] chars = my_string.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                list.add((int) c - 48);
            }
        }

        Collections.sort(list);
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}