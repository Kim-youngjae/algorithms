package com.baekjoon.data_structure.p2161;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        boolean canDiscard = true;

        while (!q.isEmpty()) {
            if (!canDiscard) {
                // 버릴 차례가 아니라면 뒤로 넣기
                q.add(q.poll());
            } else {
                // 버릴 차례
                sb.append(q.poll() + " ");
            }

            canDiscard = !canDiscard;
        }

        System.out.println(sb);
    }
}
