package com.baekjoon.p2304;

import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static class Node {
        int pos, height;

        Node(int pos, int height) {
            this.pos = pos;
            this.height = height;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            list.add(new Node(pos, height));
        }

        Collections.sort(list, new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                return o1.pos - o2.pos;
            }

        });

        int area = 0;
        for (int i = 0; i < N;) {

            int j = i + 1, max = j;
            while (j < N && list.get(i).height > list.get(j).height) {
                if (list.get(max).height < list.get(j++).height) {
                    max = j - 1;
                }
            }

            if (j < N) { // 더 큰 기둥을 만났을 때
                area += list.get(i).height * (list.get(j).pos - list.get(i).pos);
                i = j;
            } else { // 더 큰 기둥이 없을 때
                area += list.get(i).height; // 현재 기둥만 더해주기 (폭이 1)
                if (max < N) {
                    area += list.get(max).height * (list.get(max).pos - list.get(i).pos - 1); // 나머지 넓이 구해서 더해주기
                }
                i = max;
            }
        }

        System.out.println(area);

    }
}
