package com.programmers.level1.p12977;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static boolean[] visited; // 방문을 체크할 배열
    static List<Integer> results; // 3개를 뽑은 합을 저장할 리스트

    public int solution(int[] nums) {
        int n = nums.length;

        results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i + 2 == n) {
                break;
            }
            for (int j = i + 1; j < n ; j++) {
                for (int k = j + 1; k < n; k++) {
                    System.out.printf("%d %d %d\n", nums[i], nums[j], nums[k]);

                    int sum = nums[i] + nums[j] + nums[k]; // 중복을 허용하고 3개를 고르는 모든 경우의 수

                    results.add(sum);
                }
            }
        }

        visited = new boolean[n];

        combi(nums, visited, 0, n, 3);

        int cnt = 0;

        for (int num : results) {
            cnt++;
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    cnt--;
                    break;
                }
            }
        }

        return cnt;
    }

    private void combi(int[] nums, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            // 더이상 뽑을 갯수가 없으면
            int result = sumAll(nums);
            results.add(result);
        }

        for (int i = start; i < n; i++) {
            visited[i] = true; // 하나를 고르고
            combi(nums, visited, i + 1, n, r - 1); // 한 개를 고르고 남은 요소에서 나머지 뽑을 갯수(r - 1)를 뽑아야 함
            visited[i] = false;
        }
    }

    private int sumAll(int[] nums) {
        int sum = 0;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                sum += nums[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 2, 7, 6, 4});
    }
}