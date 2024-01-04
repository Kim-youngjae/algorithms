package com.baekjoon.p10828;

import java.io.*;
import java.util.*;

public class Main {
    static Stack<Integer> s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        s = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String command = st.nextToken();

            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                s.push(num);
            } else {
                sb.append(excute(command) + "\n");
            }
        }

        System.out.println(sb);
    }

    private static int excute(String cmd) {
        switch (cmd) {
            case "pop":
                if (s.isEmpty()) {
                    return -1;
                } else {
                    return s.pop();
                }
            case "size":
                return s.size();
            case "empty":
                if (s.isEmpty()) {
                    return 1;
                } else {
                    return 0;
                }
            case "top":
                if (s.isEmpty()) {
                    return -1;
                } else {
                    return s.peek();
                }
        }

        return 0;
    }
}
