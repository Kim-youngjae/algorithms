package com.baekjoon.p15658;

import java.io.*;
import java.util.*;

public class Main {
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] num;
    static int[] cmd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        cmd = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cmd[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, num[0]); // num[0] 부터 시작해서 idx가 1

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int sum) {
        if (idx == N) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cmd[i] == 0) {
                continue;
            }

            /**
             * 사용할 수 있는 연산자 개수가 있으면 개수를 하나 카운트
             */
            cmd[i]--;

            switch (i) {
                case 0:
                    dfs(idx + 1, sum + num[idx]);
                    break;
                case 1:
                    dfs(idx + 1, sum - num[idx]);
                    break;
                case 2:
                    dfs(idx + 1, sum * num[idx]);
                    break;
                case 3:
                    dfs(idx + 1, sum / num[idx]);
                    break;
            }

            /**
             * 사용한 연산자 원상 복구
             */
            cmd[i]++;
        }
    }
}
