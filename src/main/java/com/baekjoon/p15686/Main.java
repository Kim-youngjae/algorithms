package com.baekjoon.p15686;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[][] map;
    static boolean[] open;
    static List<Node> house = new ArrayList<>();
    static List<Node> shop = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    house.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    shop.add(new Node(i, j));
                }
            }
        }

        open = new boolean[shop.size()];
        dfs(0, 0);
        System.out.println(ans);
        br.close();
    }

    static void dfs(int start, int cnt) {
        if (cnt == M) {
            int res = 0;

            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;

                for (int j = 0; j < shop.size(); j++) {
                    if (open[j]) {
                        int chickenDist = Math.abs(house.get(i).r - shop.get(j).r)
                                + Math.abs(house.get(i).c - shop.get(j).c);

                        temp = Math.min(temp, chickenDist);
                    }
                }
                res += temp;
            }
            ans = Math.min(ans, res);
            return;
        }

        for (int i = start; i < shop.size(); i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }
}

class Node {
    int r;
    int c;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}