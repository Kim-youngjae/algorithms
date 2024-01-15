package com.baekjoon.p17298;

import java.io.*;
import java.util.*;

public class Main {
    static Stack<Integer> s;
    static Stack<Integer> r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        s = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (!s.isEmpty() && seq[i] > seq[s.peek()]) {
                seq[s.pop()] = seq[i];
            }

            s.push(i);
        }

        while (!s.isEmpty()) {
            seq[s.pop()] = -1;
        }

        for (int i : seq) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
