package com.swea.D2.p1983;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int rate = N / 10;

            List<Student> rank = new ArrayList<>(N);

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                float sum = 0;

                sum += Integer.parseInt(st.nextToken()) * 0.35; // 중간
                sum += Integer.parseInt(st.nextToken()) * 0.45; // 기말
                sum += Integer.parseInt(st.nextToken()) * 0.20; // 과제

                rank.add(new Student(i, sum));
            }

            Collections.sort(rank, (s1, s2) -> {
                if (s1.score - s2.score > 0) {
                    return -1;
                } else if (s1.score - s2.score == 0) {
                    return 0;
                } else {
                    return 1;
                }
            });

            int idx = 0;
            for (Student s : rank) {
                if (s.id == K) {
                    break;
                } else {
                    idx++;
                }
            }

            int gradeIdx = 0;
            // while (idx >= rate) {
            // if (K == 0) {
            // break;
            // } else {
            // gradeIdx++;
            // idx -= rate;
            // }
            // }

            gradeIdx = idx / (N / 10);

            sb.append("#").append(t).append(" ").append(grade[gradeIdx]).append("\n");
        }

        System.out.println(sb);
    }
}

class Student {
    int id;
    float score;

    public Student(int id, float score) {
        this.id = id;
        this.score = score;
    }
}