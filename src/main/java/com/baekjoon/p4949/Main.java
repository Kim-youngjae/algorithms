package com.baekjoon.p4949;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if (input.charAt(0) == '.') {
                break;
            }

            Stack<Character> s = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                char target = input.charAt(i);
                if (target == '(' || target == '[') { // 여는 괄호일 때는 그냥 push
                    s.push(target);
                } else if (target == ')') { // 닫는 괄호인데 소괄호
                    if (s.isEmpty() || s.peek() != '(') {
                        s.push(target);
                        break;
                    } else {
                        s.pop();
                    }

                } else if (target == ']') { // 닫는 괄호인데 대괄호
                    if (s.isEmpty() || s.peek() != '[') {
                        s.push(target);
                        break;
                    } else {
                        s.pop();
                    }
                }
            }

            if (s.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);
    }
}
