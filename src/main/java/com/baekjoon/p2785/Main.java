package com.baekjoon.p2785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        if (N == 2) { // 체인갯수에 상관 없이 2개이면 1번만 연결하면 된다.
            System.out.println(1);
            return;
        }

        // 2개가 아니라면
        List<Integer> chains = new ArrayList<>(); // 체인 갯수 정보를 저장

        for (int i = 0; i < N; i++) {
            int chain = Integer.parseInt(st.nextToken());
            chains.add(chain);
        }

        Collections.sort(chains);

        int cnt = 0; // 연결 횟수를 카운트

        while (chains.size() > 1) { // 체인 갯수가 1개일 때 종료 (하나로 다 연결되었다는 뜻)
            chains.set(0, chains.get(0) - 1); // 하나씩 줄이면서 세팅 제일 갯수가 작은 체인을 하나씩 줄이면서 진행
            chains.remove(chains.size() - 1); // 맨 뒤 요소 하나 삭제 (그 앞의 체인과 연결 되었다는 의미)

            if (chains.get(0) == 0) { // 0개이면 더 이상 남은 체인이 없으므로 사이즈 1개 감소
                chains.remove(0); // 그렇게 되면 1개의 긴 체인만 남게된다.
            }

            cnt++;
        }

        System.out.println(cnt);
    }

}
