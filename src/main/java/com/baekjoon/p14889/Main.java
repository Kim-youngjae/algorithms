package com.baekjoon.p14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[] visited;
    static int[][] stats;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 총 인원

        // 초기화
        stats = new int[N][N];
        visited = new boolean[N];

        // 값(개인 능력치) 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // N 명 중 N / 2 명 고르기
        combi(0, 0);
        System.out.println(minValue);
    }

    private static void combi(int start, int pick) {
        if (pick == N / 2) {
            /*
            * 수행할 로직
            * 뽑고 나면 차이를 반환해야 함
            * */
            int result = diff();

            if (result == 0) {
                return;
            }

            minValue = Math.min(minValue, result);

            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(i + 1, pick + 1);
                visited[i] = false;
            }
        }
    }

    private static int diff() {
        int start_team = 0;
        int link_team = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) { // true 이면 start 팀
                    start_team += stats[i][j];
                    start_team += stats[j][i];
                }
                else if (!visited[i] && !visited[j]) { // 나머지 false 는 link 팀
                    link_team += stats[i][j];
                    link_team += stats[j][i];
                }
            }
        }

        // 능력치 차이
        return Math.abs(start_team - link_team);
    }
}