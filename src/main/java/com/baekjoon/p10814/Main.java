package com.baekjoon.p10814;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.valueOf(br.readLine());
        Person[] people = new Person[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            people[i] = new Person(Integer.valueOf(st.nextToken()), st.nextToken());
        }

        Arrays.sort(people, comp);

        for (Person p : people) {
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }

        System.out.println(sb);
    }

    static Comparator<Person> comp = new Comparator<Person>() {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.age - o2.age;
        }
    };
}

class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // @Override
    // public int compare(Person o1, Person o2) {
    // return o1.age - o2.age;
    // }
}