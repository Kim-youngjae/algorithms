package com.baekjoon.data_structure.p17608;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            stk.push(h);
        }

        int count = 1;
        int maxHeight = stk.pop();

        while (!stk.isEmpty()) {
            int height = stk.pop();

            if (maxHeight < height) {
                count++;
                maxHeight = height;
            }
        }

        System.out.print(count);
    }
}
