package com.baekjoon.p1058;

import java.io.*;
import java.util.*;

public class Main {
    static int N, max;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            twoFriend(i);
        }

        System.out.println(max);
    }

    static void twoFriend(int me) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] v = new boolean[N];
        int cnt = 0, depth = 0;

        v[me] = true;
        q.add(me);

        while (depth < 2) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int now = q.poll();

                for (int j = 0; j < N; j++) {
                    if (map[now][j] == 'Y' && !v[j]) {
                        cnt++;
                        v[j] = true;
                        q.add(j);
                    }
                }
            }

            depth++;
        }

        if (max < cnt) {
            max = cnt;
        }

    }
}
