package com.baekjoon.p10799;

import java.io.*;
import java.util.*;

public class Main {
    static Stack<Character> s = new Stack<>();
    static int cnt; // 막대 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        boolean end = false;

        for (int i = 0; i < str.length(); i++) {
            char target = str.charAt(i);

            if (target == '(') { // 여는 괄호이면 그냥 넣기
                end = false;
                s.push(target);
            } else if (target == ')' && !end) {
                end = true;
                s.pop();
                cnt += s.size();
            } else if (target == ')' && end) { // 쇠 막대 중 하나는 자를게 없음
                s.pop();
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
