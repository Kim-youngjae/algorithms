package com.baekjoon.p17298;

import java.io.*;
import java.util.*;

public class Main {
    static Stack<Integer> s;
    static Stack<Integer> r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> sequence = new Stack<>();
        s = new Stack<>();
        r = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            sequence.push(Integer.parseInt(st.nextToken()));
        }

        s.push(sequence.pop());
        r.push(-1);

        while (!sequence.isEmpty()) {
            int temp = sequence.pop();

            while (!s.isEmpty()) {
                if (s.isEmpty()) {
                    s.push(temp);
                    r.push(-1);
                    break;
                } else {
                    int target = s.peek();

                    if (temp < target) {
                        s.push(temp);
                        r.push(target);
                        break;
                    } else {
                        s.pop();
                    }
                }
            }
        }

        while (!r.isEmpty()) {
            bw.write(r.pop() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
