package com.baekjoon.p9663;

import java.io.*;

public class Main {
    static int N, ans;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N];

        NQueen(0);

        System.out.println(ans);
    }

    static void NQueen(int depth) {
        if (depth == N) {
            ans++;
            return;
        }

        // 열을 탐색하면서 검사
        for (int i = 0; i < N; i++) {
            /*
             * depth가 열, board[depth] 값이 행이라 생각하기
             */
            board[depth] = i;
            if (isAvailable(depth)) { // 해당 열에 놓을 수 있는지 없는지 판단
                NQueen(depth + 1);
            }
        }
    }

    static boolean isAvailable(int col) {

        for (int i = 0; i < col; i++) {
            /*
             * board[col] == board[i]이면 같은 행에 위치한다는 뜻
             * col - i 와 board[col] - board[i] 절댓값이 같으면 같은 대각선에 위치한다는 뜻
             */
            if (board[col] == board[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(board[col] - board[i])) {
                return false;
            }
        }

        return true;
    }

}
