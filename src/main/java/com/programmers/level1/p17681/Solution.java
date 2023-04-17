package com.programmers.level1.p17681;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];

        // 10진수를 2진수로 바꾸기
        for (int i = 0; i < n; i++) {
            String result = Integer.toBinaryString(arr1[i] | arr2[i]);
            result = String.format("%" + n + "s", result);
            System.out.println(result);
            result = result.replaceAll("1", "#");
            result = result.replaceAll("0", " ");

            map[i] = result;
        }

        return map;
    }
}