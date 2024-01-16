package com.baekjoon.p1715;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<Integer>(Comparator.naturalOrder());

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        int total = 0;

        for (int i = 0; i < N - 1; i++) {
            int A = pq.remove();
            int B = pq.remove();
            sum = A + B;
            pq.offer(sum);
            total += sum;
        }

        System.out.println(total);
        br.close();
    }
}
