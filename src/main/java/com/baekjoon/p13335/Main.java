package com.baekjoon.p13335;

import java.io.*;
import java.util.*;

public class Main {
    static int n, w, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new ArrayDeque<>();
        Queue<Integer> bridge = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        int time = 0, curL = 0;

        while (!bridge.isEmpty()) {
            time++;
            curL -= bridge.poll();
            if (!truck.isEmpty()) {
                if (truck.peek() + curL <= L) {
                    curL += truck.peek();
                    bridge.add(truck.poll());
                } else {
                    bridge.add(0);
                }
            }
        }

        System.out.println(time);

    }
}
