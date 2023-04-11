package com.baekjoon.p10828;

//https://www.acmicpc.net/problem/10828
// 스택

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st;

        int cmd = Integer.valueOf(br.readLine()); // 명령의 수

        for (int i = 0; i < cmd; i++) {
            st = new StringTokenizer(br.readLine(), " "); // 입력받은 한 줄을 " " 기준으로 나눔

            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.valueOf(st.nextToken())); // 공백으로 나눈 다음 토큰을 push
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    int poped = stack.pop(); // stack에서 데이터를 pop
                    sb.append(poped).append("\n"); // 출력이 발생 sb에 저장
                    break;
                case "size":
                    int size = stack.size(); // 출력 발생
                    sb.append(size).append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        sb.append(1).append("\n"); // 비어있으면 1
                        break;
                    }
                    sb.append(0).append("\n");
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                        break;
                    }
                    sb.append(stack.peek()).append("\n");
                    break;
            }
        }

        System.out.println(sb);

    }
}
