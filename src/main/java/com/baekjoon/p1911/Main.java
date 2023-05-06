package com.baekjoon.p1911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numOfHoles = Integer.parseInt(st.nextToken()); // 물 웅덩이 갯수
        int plankLength = Integer.parseInt(st.nextToken()); // 널빤지 길이

        HashMap<Integer, Integer> holes = new HashMap<>(); // 물 웅덩이 위치정보

        for (int i = 0; i < numOfHoles; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()); // 물 웅덩이 시작
            int end = Integer.parseInt(st.nextToken()); // 물 웅덩이 끝

            holes.put(start, end);
        }

        Object[] mapKey = holes.keySet().toArray();
        Arrays.sort(mapKey);

        int cnt = 0;
        int newStartPoint = 0;

        for (int i = 0; i < holes.size(); i++) {

            int start = (int) mapKey[i];

            if (newStartPoint > start) {
                start = newStartPoint;
            }

            int end = holes.get(mapKey[i]);

            while (start < end) {
                start += plankLength;
                cnt++;
            }

            newStartPoint = start;
        }

        System.out.println(cnt);
    }
}
