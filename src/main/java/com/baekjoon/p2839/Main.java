package com.baekjoon.p2839;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        int cnt = 0;

        while (input > 3) {
            // 5로 나누어 떨어지면 바로 나누기
            if (input % 5 == 0) {
                cnt += input / 5;
                System.out.println(cnt);
                break;
            } else {
                input -= 3; // 3을 뺴고
                cnt++;
            }

            if (input < 5 && input % 3 != 0) {
                System.out.println(-1);
                break;
            }
        }
        sc.close();
    }
}
