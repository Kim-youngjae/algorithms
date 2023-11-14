package com.swea.p1936;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // 가위는 1, 바위는 2, 보는 3

        // 입력으로 A와 B가 무엇을 냈는지 빈 칸을 사이로 주어진다.

        int A = sc.nextInt();
        int B = sc.nextInt();

        switch (A) {
            case 1:
                if (B == 2)
                    System.out.println("B");
                else
                    System.out.println("A");
                break;
            case 2:
                if (B == 3)
                    System.out.println("B");
                else
                    System.out.println("A");
                break;
            case 3:
                if (B == 1)
                    System.out.println("B");
                else
                    System.out.println("A");
                break;
        }

        sc.close();
    }
}
