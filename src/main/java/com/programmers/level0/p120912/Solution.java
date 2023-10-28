package com.programmers.level0.p120912;

public class Solution {
    public int solution(int[] array) {
        int answer = 0;

        for (int i = 0; i < array.length; i++)
        {
            String num = Integer.toString(array[i]);

            String[] arr = num.split("");

            for(int j = 0; j < arr.length; j++)
            {
                if (arr[j].equals("7"))
                {
                    answer++;
                }
            }
        }

        return answer;
    }
}
