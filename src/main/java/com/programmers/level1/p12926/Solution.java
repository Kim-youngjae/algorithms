package com.programmers.level1.p12926;

class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 97 && arr[i] <= 122) {
                arr[i] = (char) (arr[i] + n);
                if (arr[i] > 122) {
                    arr[i] = (char) (arr[i] - 26);
                }
            } else if (arr[i] >= 65 && arr[i] <= 90) {
                arr[i] = (char) (arr[i] + n);
                if (arr[i] > 90) {
                    arr[i] = (char) (arr[i] - 26);
                }
            }
        }

        for (char c : arr) {
            answer.append(c);
        }

        return String.valueOf(answer);
    }
}