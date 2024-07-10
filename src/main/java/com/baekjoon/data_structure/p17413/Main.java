package com.baekjoon.data_structure.p17413;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String input = sc.nextLine();
        boolean reverse = true;

        for (int i = 0; i < input.length(); i++) {
            char word = input.charAt(i);

            switch (word) {
                case ' ':
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(word);
                    break;
                case '<':
                    reverse = false;
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(word);
                    break;
                case '>':
                    reverse = true;
                    sb.append(word);
                    break;
                default:
                    if (reverse) {
                        stack.push(word);
                    } else {
                        sb.append(word);
                    }
                    break;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
        sc.close();
    }
}
