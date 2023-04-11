package com.programmers.level0.p120897;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + " = " + Arrays.toString(new Solution().solution2(i)));
        }

    }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120897

class Solution {

    public int[] solution(int n) {
        int[] answer;

        //약수를 저장할 리스트
        List<Integer> list = new ArrayList<>();

        if (n == 1) {
            return new int[]{1};
        }

        //절반까지만 반복 그 이후는 의미 없음
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                // 나머지가 0이면 몫과 나눈 수 i를 더해 줌
                if (list.contains(i)) { // 이미 포함하고 있으면 넘기기
                    continue;
                }
                if ((n / i) == i) {
                    list.add(i);
                } else {
                    list.add(i);
                    list.add(n / i);
                }
            }
        }

        Collections.sort(list);

        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public int[] solution2(int n) {
        int[] answer;

        //약수를 저장할 리스트
        List<Integer> list = new ArrayList<>();
        list.add(n);

        //절반까지만 반복 그 이후는 의미 없음
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }

        Collections.sort(list);

        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}