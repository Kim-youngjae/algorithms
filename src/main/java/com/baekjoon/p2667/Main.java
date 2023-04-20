package com.baekjoon.p2667;

import java.util.*;

public class Main {
    static boolean[][] visited = new boolean[25][25];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int cntHouse = 0;
    static int[] houses = new int[25 * 25];
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = sc.next();

            for (int j = 0; j < input.length(); j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    // bfs 시작
                    cntHouse++;
                    bfs(i, j);
                }
            }
        }


        Arrays.sort(houses); // {0,0,0,0,,,,2,3,6,7}

        List<Integer> cnt = new ArrayList<>();

        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != 0) {
                cnt.add(houses[i]);
            }
        }

        System.out.printf("%d\n", cnt.size());

        for (int i : cnt) {
            System.out.println(i);
        }
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{r, c});
        visited[r][c] = true;
        houses[cntHouse]++; // 집 갯수 카운트

        while (!q.isEmpty()) {
            int[] data = q.poll();

            int currR = data[0];
            int currC = data[1];

            for (int i = 0; i < 4; i++) {
                int nr = currR + dr[i];
                int nc = currC + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (map[nr][nc] == 1 && !visited[nr][nc]) {
                        // bfs 시작
                        q.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        houses[cntHouse]++;
                    }
                }
            }
        }
    }
}