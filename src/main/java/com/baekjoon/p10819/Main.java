package com.baekjoon.p10819;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static LinkedList<Integer> a;
    static LinkedList<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        a = new LinkedList<>();
        ans = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(a);

        while (!a.isEmpty()) {
            ans.add(a.pollLast());

            for (int i = 0; i < 2; i++) {
                if (a.isEmpty()) {
                    break;
                }

                int target = a.pollFirst();

                if (Math.abs(ans.peekFirst() - target) > Math.abs(ans.peekLast() - target)) {
                    ans.addFirst(target);
                } else {
                    ans.addLast(target);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(ans.get(i) + ans.get(i + 1));
        }

        System.out.println(sum);
    }
}
