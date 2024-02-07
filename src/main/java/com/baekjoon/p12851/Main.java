package com.baekjoon.p12851;

import java.io.*;
import java.util.*;

public class Main {
    static int[] visit;
    static int n, k, cnt;
    static int minTime = Integer.MAX_VALUE;
    static int max = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visit = new int[max];

        if (n >= k) {
            System.out.println((n - k) + "\n1");
            return;
        }

        bfs(n);

        System.out.println(minTime + "\n" + cnt);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visit[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (minTime < visit[cur]) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0)
                    next = cur - 1;
                else if (i == 1)
                    next = cur + 1;
                else
                    next = 2 * cur;

                if (next < 0 || next > 100000) {
                    continue;
                }

                if (next == k) {
                    cnt++;
                    minTime = visit[cur];
                }

                if (visit[next] == 0 || visit[next] == visit[cur] + 1) {
                    q.add(next);
                    visit[next] = visit[cur] + 1;
                }
            }
        }
    }
}
