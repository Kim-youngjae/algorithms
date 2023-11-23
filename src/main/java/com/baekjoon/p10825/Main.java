package com.baekjoon.p10825;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Student> list = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            list.add(new Student(name, kor, eng, math));
        }

        Collections.sort(list, (s1, s2) -> {
            if (s1.kor == s2.kor) {
                if (s1.eng == s2.eng) {
                    if (s1.math == s2.math) {
                        return s1.name.compareTo(s2.name);
                    }
                    return s2.math - s1.math;
                }
                return s1.eng - s2.eng;
            }
            return s2.kor - s1.kor;
        });

        for (Student s : list) {
            sb.append(s.name + "\n");
        }

        System.out.println(sb);
    }
}

class Student {
    // implements Comparable<Student>
    String name;
    int kor; // 국어
    int eng; // 영어
    int math; // 수학

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    // @Override
    // public int compareTo(Student s) {
    // return this.name.compareTo(s.name);
    // }
}