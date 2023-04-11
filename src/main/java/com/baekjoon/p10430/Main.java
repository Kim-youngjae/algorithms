package com.baekjoon.p10430;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputBits = sc.nextLine().split(" ");

        int A = Integer.valueOf(inputBits[0]);
        int B = Integer.valueOf(inputBits[1]);
        int C = Integer.valueOf(inputBits[2]);

//        첫째 줄에 (A+B)%C,
        System.out.println((A + B) % C);
//        둘째 줄에 ((A%C) + (B%C))%C,
        System.out.println(((A % C) + (B % C)) % C);
//        셋째 줄에 (A×B)%C,
        System.out.println((A * B) % C);
//        넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
        System.out.println(((A % C) * (B % C)) % C);
    }
}
