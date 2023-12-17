package com.baekjoon.p2143;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 만들고자 하는 수

        int n = Integer.parseInt(br.readLine());

        int[] arrA = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> accumA = new ArrayList<>();
        List<Integer> accumB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arrA[j];
                accumA.add(sum);
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += arrB[j];
                accumB.add(sum);
            }
        }

        Collections.sort(accumA);
        Collections.sort(accumB);

        System.out.println(count(accumA, accumB, T));
    }

    private static long count(List<Integer> accumA, List<Integer> accumB, int T) {
        int pa = 0;
        int pb = accumB.size() - 1;
        long cnt = 0; // 가능한 쌍의 개수를 저장할 변수

        while (pa < accumA.size() && pb >= 0) { // 두 배열을 넘어가지 않을 동안 반복
            int total = accumA.get(pa) + accumB.get(pb);

            if (total == T) {
                long aCnt = 0;
                long bCnt = 0;

                int a = accumA.get(pa);
                int b = accumB.get(pb);

                while (pa < accumA.size() && accumA.get(pa) == a) {
                    aCnt++;
                    pa++;
                }
                while (pb >= 0 && accumB.get(pb) == b) {
                    bCnt++;
                    pb--;
                }

                cnt += aCnt * bCnt; // 동일한 갯수 세기
            } else if (total > T) {
                pb--;
            } else if (total < T) {
                pa++;
            }
        }

        return cnt;
    }
}
