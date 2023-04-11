package com.programmers.level0.p120808;

public class Main {
    public static void main(String[] args) {

    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120808
class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {0, 0};
        int rDenom = 0;
        int rNumer = 0;

        if (denom1 > denom2) {
            if (denom1 % denom2 == 0) {
                rDenom = denom1; // 분모가 큰 값
                rNumer = numer1 + (numer2 * (denom1 / denom2));
            } else {
                rDenom = denom1 * denom2; // 안나눠떨어지면 서로를 곱한 값
                rNumer = (numer1 * denom2) + (numer2 * denom1);
            }
        } else if (denom2 > denom1) {
            if (denom2 % denom1 == 0) {
                rDenom = denom2; // 분모가 큰 값
                rNumer = numer2 + (numer1 * (denom2 / denom1));
            } else {
                rDenom = denom1 * denom2; // 안나눠떨어지면 서로를 곱한 값
                rNumer = (numer1 * denom2) + (numer2 * denom1);
            }
        } else { // 같으면 분자만 서로를 더 한 값
            rDenom = denom1;
            rNumer = numer1 + numer2;
        }

        // 최대 공약수로 나누어 기약 분수 만들기
        int gcd = gcd(rNumer, rDenom);

        answer[0] = rNumer / gcd;
        answer[1] = rDenom / gcd;

        return answer;
    }
    static int gcd(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) { // 유클리드 호제법
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
