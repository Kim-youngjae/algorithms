package com.baekjoon.p1966;

import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<Node> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int cost = Integer.parseInt(st.nextToken());
                q.add(new Node(i, cost));
            }

            int ans = 1;
            while (!q.isEmpty()) {
                Node now = q.peek();
                boolean hasBigCost = false; // now보다 더 큰 비용이 존재하는지 체크

                for (int i = 0; i < q.size(); i++) {
                    if (now.cost < q.get(i).cost) {

                        for (int j = 0; j < i; j++) {
                            q.add(q.poll());
                        }

                        hasBigCost = true;
                        break;
                    }
                }

                if (!hasBigCost) { // 더 큰 중요도가 존재하지 않는다면
                    Node target = q.poll();

                    if (target.idx == M) {
                        sb.append(ans + "\n");
                    } else {
                        ans++;
                    }
                }
            }
        }

        System.out.println(sb);

    }
}
