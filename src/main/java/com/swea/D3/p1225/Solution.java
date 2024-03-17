package com.swea.D3.p1225;

import java.io.*;
import java.util.*;

public class Solution {

    static Queue<Integer> pwq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            pwq = new LinkedList<>();

            sb.append("#" + br.readLine() + " "); // 각 테스트 케이스

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                pwq.add(Integer.parseInt(st.nextToken()));
            }

            loop: while (true) {

                for (int i = 1; i <= 5; i++) {
                    int now = pwq.poll() - i;

                    if (now <= 0) {
                        pwq.add(0);
                        break loop;
                    } else {
                        pwq.add(now);
                    }
                }
            }

            while (!pwq.isEmpty()) {
                sb.append(pwq.poll() + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}
