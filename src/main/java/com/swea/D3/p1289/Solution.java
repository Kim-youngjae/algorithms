package com.swea.D3.p1289;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            String bits = sc.next();

            int count = 0;
            int[] resetBits = new int[bits.length()];

            for (int i = 0; i < bits.length(); i++) {
                // 해당 번째 비트가 같으면 넘어감
                if (bits.charAt(i) - '0' == resetBits[i]) {
                    continue;
                } else {
                    // 다르면 해당 번째 비트에서 끝까지 원래 bit의 값으로 변경
                    count++;
                    for (int j = i; j < bits.length(); j++) {
                        resetBits[j] = bits.charAt(i) - '0';
                    }
                }
            }

            sb.append(count + "\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
