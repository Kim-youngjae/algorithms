package com.programmers.level0.p120845;

public class Main {

}

//https://school.programmers.co.kr/learn/courses/30/lessons/120845

class Solution {
    public int solution(int[] box, int n) {
        int answer;

        int widthCnt = box[0] / n; // 가로로 들어갈 수 있는 최대 갯수
        int lengthCnt = box[1] / n; // 세로로 들어갈 수 있는 최대 갯수
        int heightCnt = box[2] / n; // 높이로 들어갈 수 있는 최대 갯수
        answer = widthCnt * lengthCnt * heightCnt;

        return answer;
    }
}