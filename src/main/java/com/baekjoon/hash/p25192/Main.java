package com.baekjoon.hash.p25192;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Map<String, Integer> checkMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String info = sc.next();

            switch (info) {
                case "ENTER":
                    checkMap.clear();
                    break;
                default:
                    // checkMap을 확인하면서 map에 있는지 체크
                    if (checkMap.containsKey(info)) {
                        continue;
                    } else {
                        checkMap.put(info, 0);
                        count++;
                    }
                    break;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
