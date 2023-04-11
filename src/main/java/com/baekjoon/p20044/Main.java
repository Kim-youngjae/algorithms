package com.baekjoon.p20044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // https://www.acmicpc.net/problem/20044

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> projectTeams = new ArrayList<>();
        List<Integer> projectWeights = new ArrayList<>();

        int n = Integer.valueOf(br.readLine());
        String[] bits = br.readLine().split(" ");

        for (String s : bits) {
            projectTeams.add(Integer.valueOf(s));
        }

        Collections.sort(projectTeams); // 오름 차순 정렬

        for (int i = 0; i < n; i++) { // 절반까지만 반복
            int sumOfProjectWeight = projectTeams.get(i) + projectTeams.get((2 * n - 1) - i);
            projectWeights.add(sumOfProjectWeight);
        }

        System.out.println(Collections.min(projectWeights)); // 프로젝트 팀 중 가장 역량의 합이 제일 작은 팀을 출력
    }
}
