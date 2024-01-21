package com.swea.D3.p1215;

import java.io.*;

public class Solution {
    static char[][] board;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            sb.append("#" + t + " ");

            board = new char[8][8]; // 글자판

            size = Integer.parseInt(br.readLine()); // 찾을 회문의 사이즈

            // 회문 입력 받기
            for (int i = 0; i < 8; i++) {
                String str = br.readLine();

                for (int j = 0; j < 8; j++) {
                    board[i][j] = str.charAt(j);
                }
            }

            int count = 0; // 찾은 회문의 갯수
            boolean flag = true; // 회문이 맞는지 아닌지 검사하기 위한 변수

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length - size + 1; j++) {
                    // 가로
                    flag = true;
                    for (int k = 0; k < size / 2; k++) {
                        if (board[i][j + k] != board[i][j + size - k - 1]) {
                            flag = false;
                        }
                    }
                    if (flag) {
                        count++;
                    }

                    // 세로
                    flag = true;
                    for (int k = 0; k < size / 2; k++) {
                        if (board[j + k][i] != board[j + size - k - 1][i]) {
                            flag = false;
                        }
                    }
                    if (flag) {
                        count++;
                    }
                }
            }

            sb.append(count + "\n");
        }

        System.out.println(sb);
    }
}