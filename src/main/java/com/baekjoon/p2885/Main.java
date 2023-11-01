package com.baekjoon.p2885;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.valueOf(br.readLine());
        int choco = 1;
        int count = 0;
        int n;

        while (K > choco) {
            choco *= 2;
        }

        n = choco;

        while(K > 0) {
            if (K >= n) {
                K -= n;
                count++;
            }
            else {
                n /= 2;
            }
        }

        System.out.print(choco + " ");
        System.out.println(count);
    }
}