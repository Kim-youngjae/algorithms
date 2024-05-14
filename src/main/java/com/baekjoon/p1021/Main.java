package com.baekjoon.p1021;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[M];
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;

        while (M-- > 0) {
            int target = Integer.parseInt(st.nextToken());

            if (list.peek() == target) {
                list.poll();
                continue;
            }

            int size = list.indexOf(target);

            if (size <= list.size() / 2) {
                while (list.peekFirst() != target) {
                    list.addLast(list.pollFirst());
                    cnt++;
                }
                list.poll();
            } else {
                while (list.peekLast() != target) {
                    list.addFirst(list.pollLast());
                    cnt++;
                }
                list.addFirst(list.pollLast());
                cnt++;
                list.poll();
            }

        }
        System.out.println(cnt);
    }
}
