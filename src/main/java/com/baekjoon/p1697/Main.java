package com.baekjoon.p1697;

import java.util.*;

public class Main {

    static int limit = 100001;
    static int[] node;
    static boolean[] visited;
    static int time = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력 받기
        int n = sc.nextInt(); // 수빈 위치
        int k = sc.nextInt(); // 동생 위치

        // 초기화
        node = new int[limit];
        visited = new boolean[limit];

        if (n == k) {
            System.out.println(0);
        } else {
            bfs(n, k);
            System.out.println(time);
        }

        sc.close();
    }

    private static void bfs(int n, int k) {

        Queue<Integer> q = new LinkedList<>();

        q.add(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            time++;
            int length = q.size();

            for (int i = 0; i < length; i++) { // 반복문 조건 검사식이 i < q.size()였는데 계속 사이즈가 변해서 답이 다르게 나왔음..
                int t = q.poll();
                visited[t] = true;

                if (t - 1 == k || t + 1 == k || t * 2 == k) {
                    return;
                }

                if (t - 1 >= 0 && !visited[t - 1]) {
                    q.add(t - 1);
                    visited[t - 1] = true;
                }
                if (t + 1 <= limit && !visited[t + 1]) {
                    q.add(t + 1);
                    visited[t + 1] = true;
                }
                if (t * 2 <= limit && !visited[t * 2]) {
                    q.add(t * 2);
                    visited[t * 2] = true;
                }
            }
        }
    }
}
