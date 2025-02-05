package com.programmers.level1.p64061;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int n = board[0].length;

        Stack<Integer>[] stkArr = new Stack[n];

        // 스택 배열 초기화
        for (int i = 0; i < n; i++) {
            stkArr[i] = new Stack<Integer>();
        }

        // 스택에 값 넣기
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    stkArr[j].push(board[i][j]);
                }
            }
        }

        // 인형을 넣을 스택
        Stack<Integer> dollStack = new Stack<>();

        A: for (int i = 0; i < moves.length; i++) {
            int idx = moves[i];

            if (!stkArr[idx - 1].isEmpty()) {
                int poppedDollFromArr = stkArr[idx - 1].pop();

                if (dollStack.isEmpty()) {
                    dollStack.push(poppedDollFromArr);
                    continue A;
                } else {
                    if (dollStack.peek() == poppedDollFromArr) {
                        dollStack.pop();
                        answer += 2;
                    } else {
                        dollStack.push(poppedDollFromArr);
                    }
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 },
                { 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } }, new int[] { 1, 5, 3, 5, 1, 2, 1, 4 });
    }
}