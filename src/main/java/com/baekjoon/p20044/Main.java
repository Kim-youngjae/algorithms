package com.baekjoon.p20044;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> ability = new ArrayList<>();
        List<Integer> minArr = new ArrayList<>();
        List<Integer> maxArr = new ArrayList<>();

        int sum = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 첫번째 입력
        String[] strArr = br.readLine().split(" ");// 두번째 입력

        for (int i = 0; i < strArr.length; i++)
        {
            ability.add(Integer.valueOf(strArr[i]));
        }

        Collections.sort(ability);

        //n - 1을 기준으로 정렬한 코드를 모두 정렬하면 된다

        // 작은 부분
        for (int i = 0; i <= n - 1; i++)
        {
            minArr.add(ability.get(i));
        }

        for (int i = n; i <= ability.size() - 1; i++)
        {
            maxArr.add(ability.get(i));
        }

        for (int i = 0; i < n - 1; i++)
        {
            int temp = minArr.get(i) + maxArr.get(i);

            if (temp < sum)
            {
                sum = temp;
            }
        }

        System.out.println(sum);








        // https://www.acmicpc.net/problem/20044

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        List<Integer> projectTeams = new ArrayList<>();
//        List<Integer> projectWeights = new ArrayList<>();
//
//        int n = Integer.valueOf(br.readLine());
//        String[] bits = br.readLine().split(" ");
//
//        for (String s : bits) {
//            projectTeams.add(Integer.valueOf(s));
//        }
//
//        Collections.sort(projectTeams); // 오름 차순 정렬
//
//        for (int i = 0; i < n; i++) { // 절반까지만 반복
//            int sumOfProjectWeight = projectTeams.get(i) + projectTeams.get((2 * n - 1) - i);
//            projectWeights.add(sumOfProjectWeight);
//        }
//
//        System.out.println(Collections.min(projectWeights)); // 프로젝트 팀 중 가장 역량의 합이 제일 작은 팀을 출력
    }
}
