package com.programmers.level0.p120864;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int ans = new Solution().solution("zzz111");
        System.out.println(ans);
    }

    public int solution(String my_string) {
        List<Integer> list = new ArrayList<>(); // 숫자들을 저장할 리스트
        String str = "";

        my_string += "a";

        char[] charArray = my_string.toCharArray();

        for (char c : charArray) {
            if (Character.isDigit(c)) {
                // 숫자이면 더하기
                str += c;
            } else {
                if (str.equals("")) {
                    continue;
                }
                int num = Integer.parseInt(str);
                list.add(num); // 리스트에 넣기
                str = ""; // 초기화
            }
        }

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        return sum;
    }
}