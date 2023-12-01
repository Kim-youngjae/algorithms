package com.baekjoon.p1822;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int numOfA = sc.nextInt();
        int numOfB = sc.nextInt();

        int[] arrA = new int[numOfA];
        Set<Integer> setB = new HashSet<>(numOfB);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numOfA; i++) {
            arrA[i] = sc.nextInt();
        }

        for (int i = 0; i < numOfB; i++) {
            setB.add(sc.nextInt());
        }

        for (int i : arrA) {
            if (setB.contains(i)) {
                continue;
            } else {
                result.add(i);
            }
        }

        if (result.size() == 0) {
            sb.append(0);
        } else {
            sb.append(result.size()).append("\n");
            Collections.sort(result);
            for (int i : result) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
        sc.close();
    }
}
