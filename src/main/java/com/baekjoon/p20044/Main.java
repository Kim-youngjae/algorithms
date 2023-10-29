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

        int sum = Integer.MAX_VALUE;
        int temp = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 첫번째 입력
        String[] strArr = br.readLine().split(" ");// 두번째 입력

        int lastIndex = (n * 2) - 1;

        for (int i = 0; i < strArr.length; i++)
        {
            ability.add(Integer.valueOf(strArr[i]));
        }

        Collections.sort(ability);

        for (int i = 0; i < ability.size(); i++)
        {
            if (lastIndex == n - 1) break;

            temp = ability.get(i) + ability.get(lastIndex);

            if (temp <= sum)
            {
                sum = temp;
            }

            lastIndex--;
        }

        System.out.println(sum);
    }
}
