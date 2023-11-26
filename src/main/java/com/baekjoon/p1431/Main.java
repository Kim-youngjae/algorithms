package com.baekjoon.p1431;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        List<SerialNumber> serialNumbers = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String serial = sc.next();
            int length = serial.length();
            int sum = -1;

            for (char c : serial.toCharArray()) {
                if (Character.isDigit(c)) {
                    sum += c - '0';
                }
            }

            serialNumbers.add(new SerialNumber(serial, length, sum));
        }

        Collections.sort(serialNumbers, (s1, s2) -> {
            if (s1.length == s2.length) {
                if (s1.sumDigit == s2.sumDigit) {
                    return s1.code.compareTo(s2.code);
                }
                return s1.sumDigit - s2.sumDigit;
            }
            return s1.length - s2.length;
        });

        for (SerialNumber s : serialNumbers) {
            sb.append(s.code).append("\n");
        }

        System.out.println(sb);

        sc.close();
    }
}

class SerialNumber {
    String code;
    int length;
    int sumDigit;

    public SerialNumber(String code, int length, int sumDigit) {
        this.code = code;
        this.length = length;
        this.sumDigit = sumDigit;
    }
}