package com.baekjoon.p13549;

import java.util.*;

public class Main {
    static int N, K, sec;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[100_001];
        visit = new boolean[100_001];

        if (N >= K) {
            System.out.println(N - K);
            sc.close();
            return;
        } else {
            bfs(N);
            System.out.println(sec);
        }

        sc.close();
    }

    private static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { start, 0 });

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int cPos = temp[0];
            visit[cPos] = true;

            if (cPos == K) {
                sec = temp[1];
                return;
            }

            if (cPos * 2 <= 100000 && !visit[2 * cPos]) {
                q.add(new int[] { cPos * 2, temp[1] });
            }
            if (cPos - 1 > 0 && !visit[cPos - 1]) {
                q.add(new int[] { cPos - 1, temp[1] + 1 });
            }
            if (cPos + 1 <= 100000 && !visit[cPos + 1]) {
                q.add(new int[] { cPos + 1, temp[1] + 1 });
            }

        }
    }
}
