package com.baekjoon.p5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];

        bfs(S); // bfs 시작


    }

    static void bfs(int S) {
        Queue<Floor> queue = new LinkedList<>();

        queue.add(new Floor(S, 0)); // 처음 값 큐에 넣기
        visited[S] = true; // 방문처리

        while (!queue.isEmpty()) {
            Floor current = queue.poll();// 현재 층 수

            if (current.floor == G) { // 현재 층이 목표 층이면 종료
                System.out.println(current.cnt);
                break;
            }

            if (current.floor + U <= F && !visited[current.floor + U]) { // 위로 갈 수 있는지 체크
                queue.add(new Floor(current.floor + U, current.cnt + 1));
                visited[current.floor + U] = true;
            }

            if (current.floor - D > 0 && !visited[current.floor - D]) { // 아래로 갈 수 있는지 체크
                queue.add(new Floor(current.floor - D, current.cnt + 1));
                visited[current.floor - D] = true;
            }
        }

        if (!visited[G]) {
            System.out.println("use the stairs");
        }
    }
}

class Floor {
    int floor;
    int cnt;

    public Floor(int floor, int cnt) {
        this.floor = floor;
        this.cnt = cnt;
    }
}