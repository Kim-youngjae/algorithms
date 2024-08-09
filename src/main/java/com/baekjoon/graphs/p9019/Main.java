package com.baekjoon.graphs.p9019;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            ArrayDeque<Integer> Q = new ArrayDeque<>();
            boolean[] v = new boolean[10000];
            String[] cmd = new String[10000];

            Arrays.fill(cmd, "");
            Q.add(A);
            v[A] = true;

            while (!Q.isEmpty() && !v[B]) {
                int now = Q.poll();

                int D = (2 * now) % 10000;
                int S = now == 0 ? 9999 : now - 1;
                int L = (now % 1000) * 10 + now / 1000;
                int R = (now % 10) * 1000 + now / 10;

                if (!v[D]) {
                    v[D] = true;
                    Q.add(D);
                    cmd[D] = cmd[now] + "D";
                }
                if (!v[S]) {
                    v[S] = true;
                    Q.add(S);
                    cmd[S] = cmd[now] + "S";
                }
                if (!v[L]) {
                    v[L] = true;
                    Q.add(L);
                    cmd[L] = cmd[now] + "L";
                }
                if (!v[R]) {
                    v[R] = true;
                    Q.add(R);
                    cmd[R] = cmd[now] + "R";
                }
            }

            sb.append(cmd[B] + "\n");
        }

        System.out.println(sb);

    }

}
