package com.baekjoon.p1793;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger[] d = new BigInteger[251];

        d[0] = new BigInteger("1"); // 배열 0번째 부터 넣어줘야 함 자동으로 0으로 초기화 안됨
        d[1] = new BigInteger("1");
        d[2] = new BigInteger("3");

        for (int i = 3; i <= 250; i++) {
            d[i] = d[i - 1].add(d[i - 2].multiply(new BigInteger("2")));
        }

        while (sc.hasNextInt()) {
            System.out.println(d[sc.nextInt()]);
        }
    }
}
