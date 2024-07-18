package com.baekjoon.data_structure.p7662;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            // 연산이 총 몇 개인지 입력
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < n; i++) {

                st = new StringTokenizer(br.readLine());

                // 연산 정보 입력받기
                String cmd = st.nextToken();

                if (cmd.equals("I")) {
                    int val = Integer.parseInt(st.nextToken());
                    map.put(val, map.getOrDefault(val, 0) + 1);
                } else {
                    int val = Integer.parseInt(st.nextToken());

                    // map 사이즈가 0이면 뺄 값 자체가 없는 것
                    if (map.size() == 0) {
                        continue;
                    }

                    int num = 0;
                    if (val == -1) {
                        num = map.firstKey();
                    } else {
                        num = map.lastKey();
                    }

                    // map.put 메서드는 이전에 num에 매핑된 값을 반환
                    if (map.put(num, map.get(num) - 1) == 1) {
                        map.remove(num);
                    }
                }
            }

            if (map.size() == 0) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }

        System.out.println(sb);
    }
}
