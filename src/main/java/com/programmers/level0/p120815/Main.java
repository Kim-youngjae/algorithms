package com.programmers.level0.p120815;

public class Main {
    public static void main(String[] args) {

    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120815
class Solution {
    public int solution(int n) {
//        int pizza = (6 * 1) / 10;
//        System.out.println("(6 * 1) % 10 = " + (6 * 1) % 4);
//        pizza = (6 * 2) / 10;
//        System.out.println("(6 * 2) % 10 = " + (6 * 2) % 4);
//        pizza = (6 * 3) / 10;
//        System.out.println("(6 * 3) % 10 = " + (6 * 3) % 4);
//        pizza = (6 * 4) / 10;
//        System.out.println("(6 * 4) % 10 = " + (6 * 4) % 4);
//        pizza = (6 * 5) / 10;
//        System.out.println("(6 * 5) % 10 = " + (6 * 5) % 4);
        int cnt = 1;

        while (((6 * cnt) % n) != 0) {
            if (((6 * cnt) % n) == 0) {
                break;
            }
            cnt++;
        }

        return cnt;
    }
}