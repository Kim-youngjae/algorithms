package com.swea.D3.p1860;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>(N);
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);

            boolean flag = true;

            for (int i = 0; i < N; i++) {
                int arv = list.get(i);
                if (arv < M) {
                    flag = false;
                    break;
                }
                if ((arv / M) * K - (i + 1) >= 0) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sb.append("Possible\n");
            } else {
                sb.append("Impossible\n");
            }
        }

        System.out.println(sb);

    }
}
