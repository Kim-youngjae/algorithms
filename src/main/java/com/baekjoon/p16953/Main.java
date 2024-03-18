package com.baekjoon.p16953;

import java.util.*;

public class Main {
    static long A, B;
    static int ans;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        A = sc.nextLong();
        B = sc.nextLong();

        bfs(A);
        sc.close();
    }

    static void bfs(long start) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(start * 2, 1)); // 시작
        q.add(new Node(Long.parseLong(start + "1"), 1));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.val > B) {
                continue;
            }
            if (now.val == B) {
                System.out.println(now.cnt + 1);
                return;
            }

            q.add(new Node(now.val * 2, now.cnt + 1));
            q.add(new Node(Long.parseLong(now.val + "1"), now.cnt + 1));
        }
        System.out.println("-1");
    }
}

class Node {
    long val;
    int cnt;

    Node(long val, int cnt) {
        this.val = val;
        this.cnt = cnt;
    }
}