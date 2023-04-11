package com.baekjoon.p14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] isCleaned; // 청소가 되었는지 안되었는지 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.valueOf(st.nextToken()); // 방의 크기
        int m = Integer.valueOf(st.nextToken()); // 방의 크기

        isCleaned = new boolean[n][m]; // 방 청소 구역 초기화

        st = new StringTokenizer(br.readLine(), " ");
        int currX = Integer.valueOf(st.nextToken()); // 현재 청소기 x좌표
        int currY = Integer.valueOf(st.nextToken()); // 현재 청소기 y좌표

        // 청소 유무 표시
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int dirt = Integer.valueOf(st.nextToken());
                if (dirt == 0) {
                    isCleaned[i][j] = false;
                } else {
                    isCleaned[i][j] = true;
                }
            }
        }

//        // 전체 배열 확인
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.printf("%b ", isCleaned[i][j]);
//            }
//            System.out.println();
//        }


        //                  북  동  남  서
        int[] directionX = {-1, 0, 1, 0};
        int[] directionY = {0, 1, 0, -1};

        // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        if (!isCleaned[currX - 1][currY - 1]) {
            isCleaned[currX - 1][currY - 1] = true;
        }

        // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        for (int i = 3; i < 4; i++) { // 반시계방향으로 회전

        }
    }
}
