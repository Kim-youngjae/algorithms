package com.baekjoon.data_structure.p2346;

import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int idx, val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    static ArrayDeque<Node> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            q.add(new Node(i, Integer.parseInt(st.nextToken())));
        }

        while (q.size() > 1) {
            Node node = q.pollFirst();

            sb.append(node.idx + " ");
            int num = node.val;

            if (num > 0) {
                for (int i = 1; i < num; i++) {
                    q.addLast(q.pollFirst());
                }
            } else {
                for (int i = num; i != 0; i++) {
                    q.addFirst(q.pollLast());
                }
            }
        }
        sb.append(q.poll().idx);
        System.out.println(sb);
    }
}
