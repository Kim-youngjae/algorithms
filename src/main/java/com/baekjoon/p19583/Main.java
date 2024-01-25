package com.baekjoon.p19583;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> attendance = new HashSet<>();
        Set<String> exit = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] times = new String[3];
        for (int i = 0; i < times.length; i++) {
            times[i] = st.nextToken();
        }

        int result = 0;
        String input = null;

        while ((input = br.readLine()) != null) {
            String[] target = input.split(" ");

            String chatTime = target[0];
            String name = target[1];

            // 시작 시간 전에 채팅을 했다면 출석으로 인정
            if (chatTime.compareTo(times[0]) <= 0) {
                attendance.add(name);
            }
            if (chatTime.compareTo(times[1]) >= 0 && chatTime.compareTo(times[2]) <= 0) {
                exit.add(name);
            }
        }

        for (String name : exit) {
            if (attendance.contains(name)) {
                result++;
            }
        }

        System.out.println(result);
    }
}