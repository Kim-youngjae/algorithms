package com.baekjoon.p2075;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        int count = 0;
        int val = 0;
        while (count != N) {
            val = pq.remove();
            count++;
        }

        System.out.println(val);
        br.close();
    }
}
