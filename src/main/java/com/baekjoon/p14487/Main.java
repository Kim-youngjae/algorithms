package com.baekjoon.p14487;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        List<Integer> townList = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            townList.add(Integer.valueOf(st.nextToken()));
        }

        townList.sort(Comparator.reverseOrder());

        for (int i = 1; i < townList.size(); i++) {
            result += townList.get(i);
        }

        System.out.println(result);
    }
}
