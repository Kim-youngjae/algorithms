package com.programmers.level1.p42889;

import java.util.*;

public class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        int[] arr = new int[N + 2];

        // 배열을 돌면서 해당 스테이지에 남아있는 인원 더해주기
        for (int i = 0; i < stages.length; i++) {
            // N보다 크면 모든 스테이지를 통과한 사람이라 체크 x
            if (stages[i] <= N + 1) {
                arr[stages[i]]++; // 각 스테이지의 사람을 더해주기
            }
        }

        int total = stages.length; // 전체 사람 수

        List<Stage> list = new ArrayList<>();

        // 1 ~ N까지 돌면서 실패율 구하기
        for (int i = 1; i <= N; i++) {
            double rate = total == 0 ? 0 : (double) arr[i] / total;
            list.add(new Stage(i, rate));
            total -= arr[i];
        }

        Collections.sort(list, new Comparator<Stage>() {
            @Override
            public int compare(Stage s1, Stage s2) {
                if (s1.failure - s2.failure > 0) {
                    return -1;
                } else if (s1.failure == s2.failure) {
                    return s1.idx - s2.idx;
                } else {
                    return 1;
                }
            }
        });

        answer = new int[N];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).idx;
        }

        return answer;
    }

    class Stage {
        int idx; // 스테이지 번호
        double failure; // 실패율

        public Stage(int idx, double failure) {
            this.idx = idx;
            this.failure = failure;
        }
    }
}
