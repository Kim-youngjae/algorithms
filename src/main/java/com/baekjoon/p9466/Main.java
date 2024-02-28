package com.baekjoon.p9466;

import java.io.*;
import java.util.*;

public class Main {
    static int n, cnt;
    static int[] link;
    static boolean[] v, isCycleEnd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());

            cnt = 0; // 팀에 속하는 팀원들을 세는 변수
            link = new int[n + 1]; // 해당 팀원이 누구를 찍었는지 저장할 배열
            v = new boolean[n + 1]; // 방문을 체크할 배열
            isCycleEnd = new boolean[n + 1]; // 사이클을 체크할 배열

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                link[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                dfs(i);
            }

            sb.append((n - cnt) + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int now) {
        v[now] = true; // 방문 체크
        int next = link[now]; // 현재 팀원이 찍은 팀원
        if (!v[next]) {
            dfs(next); // 방문하지 않았으면 방문하기
        } else {
            if (!isCycleEnd[next]) { // 팀원이
                cnt++;
                while (next != now) { // 사이클 조건
                    cnt++;
                    next = link[next];
                }
            }
        }
        isCycleEnd[now] = true;
    }
}
