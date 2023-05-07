package com.baekjoon.p1802;

import java.io.IOException;
import java.util.*;

public class Main {
    static String paper;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            paper = sc.next();

            if (canFold(0, paper.length() - 1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean canFold(int start, int end) { // 접을 수 있는지 없는지 체크
        if (start == end) { // 같으면 중간을 접었을 때 모두 접을 수 있다는 것
            return true;
        }

        int middlePoint = (start + end) / 2;

        for (int i = 0; i < middlePoint; i++) {
            if (paper.charAt(i) == paper.charAt(end) - i) { // 접었을 때에 접을 수 있는지 판단. 같으면 접을 수 없다는 뜻
                return false;
            }
        }

        return canFold(start, middlePoint - 1) && canFold(middlePoint + 1, end); // 중간 앞부분과 뒷부분 모두가 참이 나와야 접을 수 있음
    }
}
