package com.baekjoon.p9012;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            Stack<Character> s = new Stack<>();

            String str = br.readLine();

            for (int i = 0; i < str.length(); i++) {
                char target = str.charAt(i);

                if (target == '(') {
                    s.push(target);
                } else {
                    if (s.isEmpty()) {
                        s.push(target);
                        break;
                    } else {
                        s.pop();
                    }
                }
            }

            if (s.isEmpty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);

    }
}
