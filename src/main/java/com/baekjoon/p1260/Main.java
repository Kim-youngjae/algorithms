package com.baekjoon.p1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited; // 방문을 체크할 배열
    static int[][] nodes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //정점 갯수, 간선 갯수, 시작 정점 노드 입력받기
        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int v = Integer.valueOf(st.nextToken()); // 시작 위치

        visited = new boolean[n];
        nodes = new int[n][n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

            int a = Integer.valueOf(st2.nextToken());
            int b = Integer.valueOf(st2.nextToken());

            nodes[a - 1][b - 1] = 1; //연결된 곳은 1로 표시
            nodes[b - 1][a - 1] = 1;
        }

        dfs(v - 1);

        Arrays.fill(visited, false);
        System.out.println();

        bfs(v - 1);
    }

    public static void dfs(int v) {

        System.out.print(v + 1 + " "); // 방문한 노드는 출력
        visited[v] = true;

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[v][i] == 1 && !visited[i]) { // 갈 수 있는 노드이고 방문하지 않은 노드이면
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int num = q.poll();

            System.out.print(num + 1 + " "); // 뽑아서 확인

            for (int i = 0; i < nodes.length ; i++) {
                    if (nodes[num][i] == 1 && !visited[i]) {
                    q.add(i); // 큐에 넣고
                    visited[i] = true; // 방문했다고 표시
                }
            }
        }
    }
}
