package com.baekjoon.p9205;

import java.io.*;
import java.util.*;

public class Main {

    static int n, sx, sy, dx, dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine()); // 편의점의 갯수

            List<Node> list = new ArrayList<>(n);

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (i == 0) {
                    sx = x;
                    sy = y;
                } else if (i == n + 1) {
                    dx = x;
                    dy = y;
                } else {
                    list.add(new Node(x, y));
                }
            }

            sb.append(bfs(list));
        }

        System.out.println(sb);
    }

    private static String bfs(List<Node> list) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visit = new boolean[n];

        q.add(new Node(sx, sy));

        while (!q.isEmpty()) {
            Node temp = q.poll();
            int tx = temp.x;
            int ty = temp.y;

            if (Math.abs(tx - dx) + Math.abs(ty - dy) <= 1000) {
                return "happy\n";
            }

            for (int i = 0; i < n; i++) {
                Node next = list.get(i);
                int nx = next.x;
                int ny = next.y;

                if (!visit[i]) {
                    if (Math.abs(tx - nx) + Math.abs(ty - ny) <= 1000) {
                        q.add(new Node(nx, ny));
                        visit[i] = true;
                    }
                }
            }
        }

        return "sad\n";
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}