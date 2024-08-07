package com.baekjoon.graphs.p1697;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] dist = new int[100001];

        Arrays.fill(dist, -1);
        dist[N] = 0;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(N);

        while (dist[K] == -1) {
            int now = q.poll();

            int[] next = { now - 1, now + 1, 2 * now };

            for (int nxt : next) {
                if (nxt < 0 || nxt > 100000)
                    continue;
                if (dist[nxt] != -1)
                    continue;

                q.add(nxt);
                dist[nxt] = dist[now] + 1;
            }
        }

        System.out.println(dist[K]);
        sc.close();
    }
}
