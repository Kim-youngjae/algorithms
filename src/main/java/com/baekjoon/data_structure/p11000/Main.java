package com.baekjoon.data_structure.p11000;

import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int s;
        int t;

        Node(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] lecture = new Node[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            lecture[i] = new Node(s, t);
        }

        /**
         * 밑의 방식과 같은 정렬 방식
         */
        Arrays.sort(lecture, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.s == n2.s) {
                    return 0;
                } else if (n1.s > n2.s) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        Arrays.sort(lecture, (l1, l2) -> {
            if (l1.s == l2.s) {
                return 0;
            } else if (l1.s > l2.s) {
                return 1;
            } else {
                return -1;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(lecture[0].t);

        for (int i = 1; i < N; i++) {
            /**
             * 강의 시작이 배정된 강의 종료 시간 이후라면 pq의 강의와 합칠 수 있는 강의이므로
             * pq에서 강의를 빼고 배정되지 않은 강의의 종료시간을 pq에 넣는다.
             */
            if (lecture[i].s >= pq.peek()) {
                pq.poll();
            }
            pq.add(lecture[i].t); // 배정된 강의를 배정하기
        }

        System.out.println(pq.size());
    }
}