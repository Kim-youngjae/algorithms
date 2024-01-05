package com.baekjoon.p7785;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, String> log = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("leave")) {
                log.remove(name);
            } else {
                log.put(name, status);
            }
        }

        List<String> names = new ArrayList<>(log.keySet());

        Collections.sort(names, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String s : names) {
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }
}
