package com.baekjoon.p13975;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Queue<Long> pq = new PriorityQueue<>();

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long sum = 0L;

            while (pq.size() > 1) {
                long file1 = pq.remove();
                long file2 = pq.remove();

                long temporal = file1 + file2;
                pq.offer(temporal);
                sum += temporal;
            }

            sb.append(sum + "\n");
        }
        System.out.println(sb);

    }
}
