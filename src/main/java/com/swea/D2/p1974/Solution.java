package com.swea.D2.p1974;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            boolean flag = true;

            int[][] s = new int[9][9];

            // 스도쿠 보드 초기화
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    s[i][j] = sc.nextInt();
                }
            }

            // 열과 행 체크
            for (int i = 0; i < 9; i++) {
                int[] checkRow = new int[9];
                int[] checkCol = new int[9];

                for (int j = 0; j < 9; j++) {
                    checkRow[s[i][j] - 1]++;
                    checkCol[s[j][i] - 1]++;
                }

                for (int k = 0; k < 9; k++) {
                    if (checkRow[k] == 0 || checkCol[k] == 0) {
                        flag = false;
                        break;
                    }
                }
            }

            // 격자 체크
            for (int i = 0; i <= 6; i += 3) {
                for (int j = 0; j <= 6; j += 3) {
                    int[] check = new int[9];

                    int r = i + 3;
                    int c = j + 3;

                    for (int a = i; a < r; a++) {
                        for (int b = j; b < c; b++) {
                            check[s[a][b] - 1]++;
                        }
                    }
                    for (int x = 0; x < 9; x++) {
                        if (check[x] == 0) {
                            flag = false;
                            break;
                        }
                    }
                }
            }

            if (flag) {
                System.out.printf("#%d %d\n", t, 1);
            } else {
                System.out.printf("#%d %d\n", t, 0);
            }
        }

        sc.close();
    }
}
