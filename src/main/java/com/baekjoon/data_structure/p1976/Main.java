package com.baekjoon.data_structure.p1976;

import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int val = Integer.parseInt(st.nextToken());

                if (val == 1) {
                    union(i, j);
                }
            }
        }

        boolean canTravel = true;

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (find(start) != find(val)) {
                canTravel = false;
                break;
            }
        }

        if (!canTravel) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}
