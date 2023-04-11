package com.programmers.level0.p120887;



class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(1, 13, 1));
    }

    public int solution(int i, int j, int k) {
        int answer = 0;
        String strOfK = String.valueOf(k);
        // i부터 j까지
        for (; i <= j; i++) {
            String[] splits = String.valueOf(i).split("");
            for (String s : splits) {
                if (s.equals(strOfK)) {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}