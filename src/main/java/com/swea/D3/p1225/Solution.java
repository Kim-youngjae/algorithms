package com.swea.D3.p1225;

import java.io.*;
import java.util.*;

public class Solution {

    static Queue<Integer> pwq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 1; t++) {
            pwq = new LinkedList<>();
            int tc = Integer.parseInt(br.readLine());
            sb.append("#" + tc + " ");

            // 8개의 숫자를 입력 받는다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                pwq.add(Integer.parseInt(st.nextToken()));
            }

            int target;
            int index = 1;

            while ((target = pwq.poll()) > 0) {
                // 첫 번째 숫자를 1 감소한 뒤, 맨 뒤로 보낸다.
                target -= index;
                index++;

                // 숫자가 감소할 때 0보다 작아지는 경우 0으로 유지되며, 프로그램은 종료된다. 이 때의 8자리의 숫자 값이 암호가 된다.
                if (target > 0) {
                    pwq.add(target);
                } else {
                    target = 0;
                    pwq.add(target);
                    break;
                }
                if (index == 5) {
                    index = 1;
                }
            }

            while (!pwq.isEmpty()) {
                sb.append(pwq.poll() + " ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
