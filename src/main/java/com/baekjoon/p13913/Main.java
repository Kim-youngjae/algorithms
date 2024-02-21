package com.baekjoon.p13913;

import java.util.*;

public class Main {
    static int n, k;
    static int[] arr = new int[100001];
    static int[] before = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        n = sc.nextInt();
        k = sc.nextInt();

        bfs();

        sb.append(arr[k] + "\n");

        Stack<Integer> s = new Stack<>();
        int i = k;
        while (i != n) {
            s.push(i);
            i = before[i];
        }
        s.push(n);

        while (!s.isEmpty()) {
            sb.append(s.pop() + " ");
        }

        System.out.println(sb);
        sc.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(n);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) {
                return;
            }

            int back = now - 1;
            int front = now + 1;
            int jump = now * 2;

            if (back >= 0 && arr[back] == 0) {
                arr[back] = arr[now] + 1;
                q.add(back);
                before[back] = now;
            }
            if (front < 100001 && arr[front] == 0) {
                arr[front] = arr[now] + 1;
                q.add(front);
                before[front] = now;

            }
            if (jump < 100001 && arr[jump] == 0) {
                arr[jump] = arr[now] + 1;
                q.add(jump);
                before[jump] = now;
            }
        }

    }

}
