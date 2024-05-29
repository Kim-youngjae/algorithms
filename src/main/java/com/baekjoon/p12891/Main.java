package com.baekjoon.p12891;

import java.io.*;
import java.util.*;

public class Main {
    static int[] minCnt = new int[4], acgt = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            minCnt[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 0; i < P; i++) {
            if (str.charAt(i) == 'A') {
                acgt[0]++;
            } else if (str.charAt(i) == 'C') {
                acgt[1]++;
            } else if (str.charAt(i) == 'G') {
                acgt[2]++;
            } else if (str.charAt(i) == 'T') {
                acgt[3]++;
            }
        }

        for (int i = 0; i <= S - P; i++) {
            if (valid()) {
                ans++;
            }

            if (i == S - P) {
                break;
            }

            acgt[position(str.charAt(i))]--;
            acgt[position(str.charAt(i + P))]++;
        }

        System.out.println(ans);
    }

    static boolean valid() {
        for (int i = 0; i < 4; i++) {
            if (acgt[i] < minCnt[i]) {
                return false;
            }
        }
        return true;
    }

    static int position(char target) {
        if (target == 'A') {
            return 0;
        } else if (target == 'C') {
            return 1;
        } else if (target == 'G') {
            return 2;
        }

        return 3;
    }
}
