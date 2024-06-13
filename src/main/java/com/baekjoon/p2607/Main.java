package com.baekjoon.p2607;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String firstWord = br.readLine();

        int res = 0;

        for (int i = 0; i < N - 1; i++) {

            String str = br.readLine(); // 비교 문자열 입력받기
            int cnt = 0; // 같은 단어 개수 카운트
            int[] word = new int[26];

            for (int j = 0; j < firstWord.length(); j++) {
                word[firstWord.charAt(j) - 'A']++;
            }

            for (int j = 0; j < str.length(); j++) {
                if (word[str.charAt(j) - 'A'] > 0) {
                    cnt++;
                }
                word[str.charAt(j) - 'A']--;
            }

            // 단어의 길이가 같고 1개가 단어의 개수 차이가 1개 차이이면 카운트
            if (firstWord.length() == str.length() && (firstWord.length() == cnt || firstWord.length() - 1 == cnt)) {
                res++;
            }
            if (firstWord.length() == str.length() - 1 && str.length() - 1 == cnt) {
                res++;
            }
            if (firstWord.length() == str.length() + 1 && str.length() == cnt) {
                res++;
            }
        }

        System.out.println(res);
    }
}
