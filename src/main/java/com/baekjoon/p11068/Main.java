package com.baekjoon.p11068;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int number = Integer.parseInt(br.readLine());
            boolean flag = false;

            for (int i = 2; i <= 64 && !flag; i++) {
                flag = checkPalindrome(number, i);
            }
            sb.append(flag ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }

    static boolean checkPalindrome(int num, int idx) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % idx);
            num = num / idx;
        }

        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
