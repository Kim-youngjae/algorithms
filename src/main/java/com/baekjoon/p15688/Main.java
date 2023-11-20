package com.baekjoon.p15688;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// * 사용한 import도 시간에 영향을 미친다.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // valueOf()보다 parseInt()가 조금 더 빠르다
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n"); // append()를 두번 하는 것이 더 빠르다. 매개변수로 문자열을 붙이면 새로운 문자열을 생성해 인자로 전달하여 비용 더 발생
        }

        System.out.println(sb);
    }
}