package com.baekjoon.p1697;

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[100001];
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n);
        System.out.println(arr[k]);
    }

    private static void bfs(int val) {
        Queue<Integer> q = new LinkedList<>();

        q.add(val);

        while (!q.isEmpty()) {
            int temp = q.remove();

            if (temp == k) {
                return;
            }

            int back = temp - 1;
            int front = temp + 1;
            int jump = temp * 2;

            if (back >= 0 && arr[back] == 0) {
                q.add(back);
                arr[back] = arr[temp] + 1;
            }
            if (front <= 100000 && arr[front] == 0) {
                q.add(front);
                arr[front] = arr[temp] + 1;
            }
            if (jump <= 100000 && arr[jump] == 0) {
                q.add(jump);
                arr[jump] = arr[temp] + 1;
            }
        }
    }
}
