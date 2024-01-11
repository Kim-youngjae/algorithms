package com.baekjoon.p13414;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int canAfford = Integer.parseInt(st.nextToken()); // 수강 신청 가능 수
        int apply = Integer.parseInt(st.nextToken()); // 지원한 횟수

        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 0; i < apply; i++) {
            String studentId = br.readLine();

            if (set.contains(studentId)) {
                set.remove(studentId);
            }
            set.add(studentId);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String s : set) {
            sb.append(s + "\n");
            count++;
            if (count == canAfford)
                break;
        }

        System.out.println(sb);
    }
}
