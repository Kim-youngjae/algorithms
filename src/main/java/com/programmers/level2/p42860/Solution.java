package com.programmers.level2.p42860;

class Solution {
    public static boolean isDebug = false;

    public int solution(String name) {
        int answer = 0;

        int N = name.length();
        int moveLeftNRight = N - 1;
        int idx;

        for (int i = 0; i < N; i++) {
            char c = name.charAt(i);
            int moveUpAndDown = Math.min(c - 'A', 'Z' - c + 1);

            if (moveUpAndDown > 0) {
                answer += moveUpAndDown;
            }

            idx = i + 1;
            while (idx < N && name.charAt(idx) == 'A') {
                idx++;
            }

            moveLeftNRight = Math.min(moveLeftNRight, N - idx + i * 2); // 오른쪽 찍고 왼쪽으로 가는 최소 이동

            moveLeftNRight = Math.min(moveLeftNRight, 2 * (N - idx) + i); // 왼쪽으로 가서 오른쪽으로 다시 오는 최소 이동
        }

         return answer + moveLeftNRight;
    }

}