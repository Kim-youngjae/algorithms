package com.baekjoon.p18258;

import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String command = st.nextToken();

            if (command.equals("push")) {
                int val = Integer.parseInt(st.nextToken());
                dq.add(val);
            } else {
                sb.append(excute(command) + "\n");
            }
        }
        System.out.println(sb);
    }

    private static int excute(String command) {
        switch (command) {
            case "size":
                break;
            case "pop":
                if (dq.isEmpty()) {
                    return -1;
                }
                return dq.pop();
            case "empty":
                if (dq.isEmpty()) {
                    return 1;
                }
                return 0;
            case "front":
                if (dq.isEmpty()) {
                    return -1;
                }
                return dq.peek();
            case "back":
                if (dq.isEmpty()) {
                    return -1;
                }
                return dq.getLast();
        }

        return dq.size();
    }
}
