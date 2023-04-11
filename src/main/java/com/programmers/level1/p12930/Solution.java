package com.programmers.level1.p12930;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        String[] splits = s.split("");

        int cnt = 0;

        for (int i = 0; i < splits.length; i++) {
            if (splits[i].equals(" ")) {
                cnt = 0;
                sb.append(splits[i]);
            } else if (cnt % 2 == 0) {
                sb.append(splits[i].toUpperCase());
                cnt++;
            } else {
                sb.append(splits[i].toLowerCase());
                cnt++;
            }
        }

        answer += sb.toString();

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("try hello world"));
        System.out.println(new Solution().solution(" ABC   DEFGH"));
    }
}