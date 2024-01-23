package com.baekjoon.p11478;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        Set<String> set = new HashSet<>();

        int size = str.length();

        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < size - i + 1; j++) {
                String target = str.substring(j, j + i);
                set.add(target);
            }
        }

        int count = 0;
        Iterator<String> iter = set.iterator(); // set은 iterator로 꺼내기
        while (iter.hasNext()) {
            iter.next();
            count++;
        }

        System.out.println(count);
        sc.close();
    }
}
