package com.baekjoon.p1764;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> neverHeard = new HashSet<>();
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            neverHeard.add(name);
        }
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (neverHeard.contains(name)) {
                ans.add(name);
            }
        }

        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();

        sb.append(ans.size() + "\n");
        for (String s : ans) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }
}
