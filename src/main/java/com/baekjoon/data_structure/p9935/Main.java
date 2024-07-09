package com.baekjoon.data_structure.p9935;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = br.readLine();
        String bombStr = br.readLine();
        int bombLen = bombStr.length();

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < inputStr.length(); i++) {
            // 스택에 입력 문자열 넣기
            s.push(inputStr.charAt(i));

            /*
             * 폭발 문자열과 길이가 같거나 긴 경우 폭발 문자열을 포함하는지 검사
             * 스택 사이즈가 폭발문자열보다 큰 경우 탐색을 계속하지만 폭발 문자열과 하나라도 일치하지 않는 경우
             * 탐색을 바로 중단하고 다음 입력 문자열을 스택에 푸시하고 검사
             */
            if (s.size() >= bombLen) {
                boolean findBomb = true;

                // 폭발 문자열 길이 만큼만 검사 이전 문자열들은 이미 폭발 문자열이 아님
                for (int j = 0; j < bombLen; j++) {
                    if (s.get(s.size() - bombLen + j) != bombStr.charAt(j)) {
                        findBomb = false;
                        break;
                    }
                }
                // 폭발 문자열을 발견했다면 폭발 문자열 길이 만큼 pop
                if (findBomb) {
                    for (int j = 0; j < bombLen; j++) {
                        s.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if (s.size() == 0) {
            sb.append("FRULA");
        } else {
            for (int i = 0; i < s.size(); i++) {
                sb.append(s.get(i));
            }
        }

        System.out.println(sb);
    }
}
