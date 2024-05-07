package com.baekjoon.p1326;

import java.io.*;
import java.util.*;

public class Main {
    static int N, S, E;
    static int[] a;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        if (S == E) {
            System.out.println(0);
        } else {
            bfs();
        }
    }

    static class Node {
        int pos;
        int jmp;

        Node(int pos, int jmp) {
            this.pos = pos;
            this.jmp = jmp;
        }
    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        v = new boolean[10000 + 1];

        v[S] = true;
        q.add(new int[] { S, 0 });

        while (!q.isEmpty()) {

            int[] now = q.poll();
            int num = a[now[0]];
            int next = now[0]; // 1이고 a[1] = 1 -> next = 1 + a[1] = 1 + 1 = 2

            while (true) {
                next += num; // 더해주어 배수로 만든다.
                if (next > N)
                    break;
                if (v[next]) {
                    continue;
                }
                if (next == E) {
                    System.out.println(now[1] + 1);
                    return;
                }

                q.add(new int[] { next, now[1] + 1 });
            }

            next = now[0]; // 다시 초기화 -> 음수 배수로 탐색하기 위함
            while (true) {
                next -= num; // 뺴주어 음수 배수로 만든다
                if (next < 1)
                    break;
                if (v[next]) {
                    continue;
                }
                if (next == E) {
                    System.out.println(now[1] + 1);
                    return;
                }
                q.add(new int[] { next, now[1] + 1 });
            }

        }
        System.out.println(-1);
    }
}
