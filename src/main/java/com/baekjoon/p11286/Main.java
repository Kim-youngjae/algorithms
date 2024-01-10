package com.baekjoon.p11286;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>(
                Comparator
                        .comparing(Node::getAbsValue)
                        .thenComparing(Node::getValue));

        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();

            if (temp != 0) {
                pq.offer(new Node(temp, Math.abs(temp)));
            } else {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    Node node = pq.poll();
                    sb.append(node.value + "\n");
                }
            }
        }

        System.out.println(sb);
        sc.close();
    }
}

class Node {
    int value;
    int absValue;

    public Node(int value, int absValue) {
        this.value = value;
        this.absValue = absValue;
    }

    int getValue() {
        return value;
    }

    int getAbsValue() {
        return absValue;
    }
}