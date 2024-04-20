package com.baekjoon.p1966;

import java.io.*;
import java.util.*;

public class Main {
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            ans = 0;
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken()); // 뽑고자 하는 순서 번호

            LinkedList<Node> q = new LinkedList<>(); // 큐처럼 활용할 리스트
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                q.add(new Node(i, Integer.parseInt(st.nextToken())));
            }

            while (!q.isEmpty()) {

                Node target = q.poll();
                boolean flag = true;

                for (int i = 0; i < q.size(); i++) {

                    if (target.value < q.get(i).value) { // 큐에 더 큰 중요도가 존재하면
                        q.add(target); // 제일 뒤로 넣기

                        for (int j = 0; j < i; j++) { // 큰 중요도에 해당하는 큐만큼 뽑고 다시 넣기를 반복
                            q.add(q.poll());
                        }

                        flag = false;
                        break;
                    }

                }

                if (!flag) {
                    continue;
                }

                ans++;

                if (target.rank == M) {

                    break;
                }
            }
            sb.append(ans + "\n");
        }

        System.out.println(sb);

    }
}

class Node {
    int rank;
    int value;

    Node(int rank, int value) {
        this.rank = rank;
        this.value = value;
    }
}
