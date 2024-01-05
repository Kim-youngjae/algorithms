package com.baekjoon.p10845;

import java.util.*;

public class Main {
    static Deque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String command = sc.next();

            if (command.equals("push")) {
                int val = sc.nextInt();
                q.add(val);
            } else {
                sb.append(excute(command) + "\n");
            }
        }

        System.out.println(sb);
        sc.close();
    }

    private static int excute(String command) {
        switch (command) {
            case "pop":
                if (q.isEmpty()) {
                    return -1;
                }
                return q.remove();
            case "empty":
                if (q.isEmpty()) {
                    return 1;
                }
                return 0;
            case "front":
                if (q.isEmpty()) {
                    return -1;
                }
                return q.peek();
            case "back":
                if (q.isEmpty()) {
                    return -1;
                }
                return q.getLast();
            case "size":
                break;
        }

        return q.size();
    }
}
