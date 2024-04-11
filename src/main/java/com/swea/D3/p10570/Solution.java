package com.swea.D3.p10570;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int cnt = 0;

            for (int i = A; i <= B; i++) {
                if (isPalindrome(i)) {
                    cnt++;
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }

    static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        double sqrtNum = Math.sqrt(num);

        if (sqrtNum != Math.ceil(sqrtNum)) { // 제곱근이 정수인지 검사해야 함
            return false;
        }

        str = String.valueOf((int) Math.sqrt(num));
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

}
