package com.baekjoon.p1406;

import java.io.*;
import java.util.*;

public class Main {
    static Stack<Character> left = new Stack<>();
    static Stack<Character> right = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        // 명령어 입력 받기
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            switch (cmd) {
                case "L": // 커서를 왼쪽으로 이동
                    // 커서가 문장의 맨 앞이면 무시
                    if (!left.isEmpty())
                        right.push(left.pop());
                    break;
                case "D": // 커서를 오른쪽으로 이동
                    // 커서가 문장의 맨 뒤이면 무시
                    if (!right.isEmpty())
                        left.push(right.pop());
                    break;
                case "B": // 커서 왼쪽에 있는 문자를 삭제
                    if (!left.isEmpty())
                        left.pop();
                    break;
                case "P":
                    String val = st.nextToken();
                    left.push(val.charAt(0));
                    break;
            }

        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.print(sb);
    }
}
