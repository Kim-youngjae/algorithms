package com.baekjoon.data_structure.p7662;

import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            // 연산이 총 몇 개인지 입력
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();

            for (int i = 0; i < n; i++) {

                st = new StringTokenizer(br.readLine());

                // 연산 정보 입력받기
                String cmd = st.nextToken();

                if (cmd.equals("I")) {
                    int val = Integer.parseInt(st.nextToken());

                    min.add(val);
                    max.add(val);
                    map.put(val, map.getOrDefault(val, 0) + 1);
                } else {
                    int val = Integer.parseInt(st.nextToken());

                    // map 사이즈가 0이면 뺄 값 자체가 없는 것
                    if (map.size() == 0) {
                        continue;
                    }

                    if (val == -1) {
                        delete(min);
                    } else {
                        delete(max);
                    }
                }
            }

            if (map.size() == 0) {
                sb.append("EMPTY\n");
            } else {
                int res = delete(max);
                sb.append(res + " "); // 최댓값
                if (map.size() > 0)
                    res = delete(min);
                sb.append(res + "\n"); // 최솟값
            }
        }

        System.out.println(sb);
    }

    static int delete(Queue<Integer> q) {
        int res = 0;

        while (true) {
            res = q.poll();

            int val = map.getOrDefault(res, 0);

            // map에도 값이 없으면 최대/최소 큐에서 뺀 이력이 있는 것
            if (val == 0) {
                continue;
            }

            if (val == 1) {
                map.remove(res);
            } else {
                map.put(res, val - 1);
            }

            break;
        }

        return res;
    }
}
