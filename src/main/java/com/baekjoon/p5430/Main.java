package com.baekjoon.p5430;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            String cmd = br.readLine();

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            ArrayDeque<Integer> dq = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            AC(dq, cmd);
        }

        System.out.print(sb);
    }

    static void AC(ArrayDeque<Integer> dq, String cmd) {

        boolean isReverse = false;

        for (int i = 0; i < cmd.length(); i++) {
            if (cmd.charAt(i) == 'R') {
                isReverse = !isReverse; // 덱 마지막으로 포인터 이동
                continue;
            }

            if (isReverse) { // 뒤집혀 있는 상태이므로 뒤에서 빼주기
                if (dq.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (dq.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        printResult(dq, isReverse);
    }

    static void printResult(ArrayDeque<Integer> dq, boolean isReverse) {
        sb.append("[");

        if (dq.size() > 0) {
            if (isReverse) {
                sb.append(dq.pollLast());

                while (!dq.isEmpty()) {
                    sb.append(",").append(dq.pollLast());
                }

            } else {
                sb.append(dq.pollFirst());

                while (!dq.isEmpty()) {
                    sb.append(",").append(dq.pollFirst());
                }
            }
        }

        sb.append("]\n");

    }
}
