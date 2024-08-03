package com.baekjoon.data_structure.p28278;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "1":
                    // 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
                    s.push(Integer.parseInt(input[1]));
                    break;
                case "2":
                    // 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
                    if (!s.isEmpty()) {
                        sb.append(s.pop() + "\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case "3":
                    // 3: 스택에 들어있는 정수의 개수를 출력한다.
                    sb.append(s.size() + "\n");
                    break;
                case "4":
                    // 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
                    if (s.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "5":
                    // 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
                    if (s.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(s.peek() + "\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
