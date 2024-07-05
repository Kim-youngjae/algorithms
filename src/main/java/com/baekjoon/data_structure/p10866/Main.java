package com.baekjoon.data_structure.p10866;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            switch (cmd) {
                case "push_front":
                    q.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    q.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.pollFirst()).append("\n");
                    }
                    break;

                case "pop_back":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.pollLast()).append("\n");
                    }
                    break;

                case "size":
                    sb.append(q.size()).append("\n");
                    break;

                case "empty":
                    if (q.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;

                case "front":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.peekFirst()).append("\n");
                    }
                    break;

                case "back":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(q.peekLast()).append("\n");
                    }
                    break;

            }
        }

        System.out.println(sb);

    }
}
