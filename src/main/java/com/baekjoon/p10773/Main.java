package com.baekjoon.p10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/10773
// 제로
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        // 몇 개의 수를 입력 받을지
        int inputNum = Integer.valueOf(br.readLine());

        for (int i = 0; i < inputNum; i++) {
            int num = Integer.valueOf(br.readLine());
            if (num == 0) {
                stack.pop(); // 0 -> 잘 못 부른 수 스택에서 팝
            } else {
                stack.push(num); // 0이 아닌 수는 스택에 푸시
            }
        }

        int sum = 0;

        while (!stack.isEmpty()) {
            // stack이 비어있지 않은 동안
            sum += stack.pop();// 남아있던 모든 수를 뽑아서 저장
        }

        System.out.println(sum);
    }
}
