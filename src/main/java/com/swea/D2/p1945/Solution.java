package com.swea.D2.p1945;

import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int num = sc.nextInt();

            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;

            while (true) {
                if (num % 2 == 0) {
                    num /= 2;
                    a++;
                } else if (num % 3 == 0) {
                    num /= 3;
                    b++;
                } else if (num % 5 == 0) {
                    num /= 5;
                    c++;
                } else if (num % 7 == 0) {
                    num /= 7;
                    d++;
                } else if (num % 11 == 0) {
                    num /= 11;
                    e++;
                }

                if (num == 1)
                    break;
            }

            System.out.printf("#%d %d %d %d %d %d\n", t, a, b, c, d, e);
        }

        sc.close();
    }
}