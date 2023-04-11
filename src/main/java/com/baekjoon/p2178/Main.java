package com.baekjoon.p2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] maze;
    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{-1, 0, 1, 0};
    static int n;
    static int m;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        // 미로 생성
        maze = new int[n][m];
        // 방문을 체크할 배열 초기화
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] splits = br.readLine().split("");

            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.valueOf(splits[j]);
            }
        }


        visited[0][0] = true; // 첫 노드 방문처리
        bfs(0, 0);
        System.out.println(maze[n - 1][m - 1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y}); // 좌표 넣기

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            int currX = tmp[0]; // 현재 x
            int currY = tmp[1]; // 현재 y

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i]; // 다음 x
                int nextY = currY + dy[i]; // 다음 y
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m){
                    if (!visited[nextX][nextY] && maze[nextX][nextY] != 0) {
                        q.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        maze[nextX][nextY] = maze[currX][currY] + 1;
                    }
                }
            }
        }
    }
}
