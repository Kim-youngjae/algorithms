package com.programmers.level0.p181936;

class Solution {
    public int solution(int number, int n, int m) {
        if (isMultiplesOfN(number, n) && isMultiplesOfM(number, m)) {
            return 1;
        } else {
            return 0;
        }
    }

    private boolean isMultiplesOfM(int number, int m) {
        return number % m == 0;
    }

    private boolean isMultiplesOfN(int number, int n) {
        return number % n == 0;
    }
}
