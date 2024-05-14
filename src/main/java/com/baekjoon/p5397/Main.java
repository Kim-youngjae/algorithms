package com.baekjoon.p5397;

import java.io.*;
import java.util.*;

public class Main {
    static Stack<Character> left;
    static Stack<Character> right;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            left = new Stack<>();
            right = new Stack<>();

            String L = br.readLine();

            for (int i = 0; i < L.length(); i++) {
                exec(L.charAt(i));
            }

            while (!right.isEmpty()) {
                left.push(right.pop());
            }

            for (int i = 0; i < left.size(); i++) {
                sb.append(left.get(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void exec(char cmd) {
        switch (cmd) {
            case '<':
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
                break;
            case '>':
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
                break;
            case '-':
                if (!left.isEmpty()) {
                    left.pop();
                }
                break;
            default:
                left.push(cmd);
        }
    }
}
