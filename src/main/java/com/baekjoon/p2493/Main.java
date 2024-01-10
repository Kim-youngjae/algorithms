package com.baekjoon.p2493;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Tower[] tower = new Tower[N];

        Stack<Tower> s = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int towerHeight = Integer.parseInt(st.nextToken());
            tower[i] = new Tower(towerHeight, i + 1);
        }

        int idx = 0;

        while (true) {

            if (idx == N) {
                break;
            }

            Tower temp = tower[idx];
            // 스택이 비어 있으면 넣기

            if (s.isEmpty()) {
                sb.append("0 ");
                s.push(temp);
                idx++;
            } else {
                Tower peek = s.peek();

                if (peek.height > temp.height) {
                    sb.append(peek.index + " ");
                    s.push(temp);
                    idx++;
                } else {
                    s.pop();

                }
            }
        }

        System.out.println(sb);
    }
}

class Tower {
    int height;
    int index;

    public Tower(int height, int index) {
        this.height = height;
        this.index = index;
    }
}