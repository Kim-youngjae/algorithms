package com.baekjoon.p1781;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Quiz> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            pq.add(new Quiz(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Queue<Integer> ans = new PriorityQueue<>();

        long result = 0;
        while (!pq.isEmpty()) {
            Quiz curr = pq.poll();
            if (ans.size() < curr.deadline) {
                ans.add(curr.ramen);
            } else {
                int target = ans.peek();
                if (target < curr.ramen) {
                    ans.poll();
                    ans.add(curr.ramen);
                }
            }
        }

        while (!ans.isEmpty()) {
            result += ans.remove();
        }

        System.out.println(result);
    }
}

class Quiz implements Comparable<Quiz> {
    int deadline;
    int ramen;

    Quiz(int deadline, int ramen) {
        this.deadline = deadline;
        this.ramen = ramen;
    }

    @Override
    public int compareTo(Quiz q) {
        if (this.deadline == q.deadline) {
            return q.ramen - this.ramen;
        } else {
            return this.deadline - q.deadline;
        }
    }
}
