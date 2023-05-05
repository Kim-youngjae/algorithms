package com.baekjoon.p12018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int subjectNum = Integer.parseInt(st.nextToken()); // 과목 수
        int mileage = Integer.parseInt(st.nextToken()); // 마일리지

        int[] minimumMileage = new int[subjectNum]; // 각 과목 수당 필요한 최소 마일리지를 저장

        for (int i = 0; i < subjectNum; i++) { // 전체 과목 수만큼 입력받기
            // 첫째 줄
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken()); // 과목 신청 사람 수
            int l = Integer.parseInt(st.nextToken()); // 수강 정원

            List<Integer> scoreList = new ArrayList<>();

            // 둘째 줄 시작
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < p; j++) {
                scoreList.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(scoreList, Collections.reverseOrder()); // 내림차순 정렬

            if (p < l) { // 신청 사람 수가 수강 정원 보다 작으면 마일리지가 1만 있으면 된다.
                minimumMileage[i] = 1;
                continue;
            }

            // 신청 사람 수가 더 많으면 마일리지가 최대 정원 번째의 마일리지와 같으면 된다.
            minimumMileage[i] = scoreList.get(l - 1);
        }

        Arrays.sort(minimumMileage);

        int cnt = 0;

        for (int i = 0; i < minimumMileage.length; i++) {
            mileage -= minimumMileage[i];
            if (mileage < 0) { // 0이랑 같다는 조건을 걸면 카운트가 하나가 안된다..
                break;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}