package com.programmers.level1.p42862;

import java.util.Arrays;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] students = new int[n]; // 전체 학생 수

        Arrays.fill(students, 1);

        for (int i = 0; i < lost.length; i++) {
            int idx = lost[i];
            students[idx - 1] = 0;
        }

        for (int i = 0; i < reserve.length; i++) {
            int idx = reserve[i];
            students[idx - 1] += 1;
        }

        for (int i = 0; i < students.length; i++) {
            // 제일 처음 학생
            if (i == 0) {
                if (students[i] > 1 && students[i + 1] == 0) {
                    students[i] -= 1;
                    students[i + 1] += 1;
                }
            } else if (i == students.length - 1) { // 제일 마지막 학생
                if (students[i] > 1 && students[i - 1] == 0) {
                    students[i] -= 1;
                    students[i - 1] += 1;
                }
            } else { // 2번째 부터 제일 마지막 앞의 학생
                if (students[i] > 1) { // 여벌이 있고
                    if (students[i - 1] == 0 && students[i] > 1) { // 다음 사람은 있었는데 그 전 사람이 없을 때
                        students[i] -= 1;
                        students[i - 1] += 1;
                    } else if (students[i + 1] == 0 && students[i] > 1) { // 다음 사람이 체육복이 없는 경우
                        students[i] -= 1;
                        students[i + 1] += 1;
                    }
                }
            }
        }

        for (int i : students) {
            if (i >= 1) {
                answer += 1;
            }
        }

        return answer;
    }
}
