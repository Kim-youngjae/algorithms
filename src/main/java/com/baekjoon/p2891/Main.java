package com.baekjoon.p2891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] kayak;

        st = new StringTokenizer(br.readLine(), " "); // 입력 받은 값을 " " 단위로 끊어서 토큰화
        int N = Integer.valueOf(st.nextToken());
        int S = Integer.valueOf(st.nextToken());
        int R = Integer.valueOf(st.nextToken());

        kayak = new int[N];

        // 모든 팀을 1로 초기화
        for (int i = 0; i < N; i++) {
            kayak[i] = 1;
        }

        // 부서진 팀
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < S; i++) {
            int teamNumber = Integer.valueOf(st2.nextToken());
            kayak[teamNumber - 1]--;
        }

        //카약 하나씩 더 있는 팀
        StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < R; i++) {
            int teamNumber = Integer.valueOf(st3.nextToken());
            kayak[teamNumber - 1]++;
        }

        System.out.println(Arrays.toString(kayak));

        for (int i = 0; i < kayak.length; i++) {
            if (kayak[i] == 2) { // 나눠줄 수 있는 팀이고
                if (i == 0) {
                    // 2개 있는 팀이 첫 번째 팀이라면
                    if (kayak[i + 1] == 0) {
                        // 다음 팀만 카약이 있는지 없는지 검사
                        kayak[i] -= 1; // 해당 팀 카약 갯수를 1감소
                        kayak[i + 1] += 1; // 다음 팀 카약 갯수 증가
                    }
                } else if (i == N - 1) {
                    // 카약 두개를 가지고 있는 팀이 마지막 팀이고
                    if (kayak[i - 1] == 0) {
                        // 마지막 바로 앞 팀이 없는지만 검사
                        kayak[i] -= 1;
                        kayak[i - 1] += 1;
                    }
                } else {
                    // 첫 번째 마지막 팀 말고 나머지 팀만
                    if (kayak[i] > 1 && kayak[i - 1] == 0) { // 나눠줄 수 있고 그 전 팀이 없는 경우
                        kayak[i - 1] += 1;
                        kayak[i] -= 1;
                    } else if (kayak[i] > 1 && kayak[i + 1] == 0) { // 나눠줄 수 있고 그 다음 팀이 없는 경우
                        kayak[i + 1] += 1;
                        kayak[i] -= 1;
                    }
                }
            }
        }

        int cnt = 0;

        for (int i : kayak) {
            if (i == 0) {
                cnt++;
            }
        }


        System.out.println(Arrays.toString(kayak));
        System.out.println(cnt);
    }
}
