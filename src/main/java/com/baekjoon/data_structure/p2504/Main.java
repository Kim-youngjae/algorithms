package com.baekjoon.data_structure.p2504;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String brackets = br.readLine();

        Stack<Character> stk = new Stack<>();

        int res = 0;
        int tmp = 1;
        boolean isCorrect = true;

        for (int i = 0; i < brackets.length(); i++) {
            char now = brackets.charAt(i);

            if (now == '(') {
                stk.push(now);
                tmp *= 2;
            } else if (now == '[') {
                stk.push(now);
                tmp *= 3;
            } else {
                if (now == ')') {
                    if (stk.isEmpty() || stk.peek() != '(') {
                        isCorrect = false;
                        break;
                    }
                    /*
                     * 여기 부분을 이해하지 못함.
                     * 열린 괄호까지 계속해서 연산을 해준다음 처음 만나는 여는 괄호가 올바르면
                     * 그 때까지의 연산을 더해주면 그 이후 닫는 괄호에 대해서는
                     * 스택의 여는 괄호를 빼주고 분배법칙 연산한 값을 원복 시키는 역할을 해야한다.
                     * [] 괄호 역시 똑같이 적용
                     */
                    if (brackets.charAt(i - 1) == '(') {
                        res += tmp;
                    }
                    stk.pop();
                    tmp /= 2;
                } else if (now == ']') {
                    if (stk.isEmpty() || stk.peek() != '[') {
                        isCorrect = false;
                        break;
                    }
                    if (brackets.charAt(i - 1) == '[') {
                        res += tmp;
                    }
                    stk.pop();
                    tmp /= 3;
                }
            }
        }

        if (!isCorrect || !stk.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(res);
        }

    }
}
