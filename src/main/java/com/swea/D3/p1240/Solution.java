package com.swea.D3.p1240;

import java.util.*;

public class Solution {
    static Map<String, Integer> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        map = new HashMap<>();
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // 세로
            int M = sc.nextInt(); // 가로

            String target = "";
            int[] codes = new int[2];

            for (int i = 0; i < N; i++) {
                String code = sc.next();

                for (int j = M - 1; j > 0; j--) {
                    if (code.charAt(j) - '0' == 1) { // 끝 인덱스에서 1을 만나면
                        // 여기서부터 56자리를 자르기
                        target = code.substring(j - 55, j + 1);
                        codes = getRealCodeNum(target);
                        break;
                    }
                }
            }

            int result = codes[0] * 3 + codes[1];

            if (result % 10 == 0) {
                sb.append("#" + t + " " + (codes[0] + codes[1]) + "\n");
            } else {
                sb.append("#" + t + " 0\n");
            }
        }

        System.out.println(sb);
        sc.close();
    }

    private static int[] getRealCodeNum(String target) {
        int[] result = new int[2];

        // 7자리씩 끊어서 8개의 숫자 추출
        for (int i = 0; i < target.length(); i += 7) {
            String codeNum = target.substring(i, i + 7);
            int val = map.get(codeNum);
            if ((i / 7) % 2 == 0) {
                result[0] += val; // 짝수
            } else {
                result[1] += val; // 홀수
            }
        }

        return result;
    }
}
