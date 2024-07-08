package com.baekjoon.data_structure.p1269;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (sizeA-- > 0) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        while (sizeB-- > 0) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        int AsubB = 0;
        int BsubA = 0;

        for (int i : A) {
            if (!B.contains(i)) {
                AsubB++;
            }
        }

        for (int i : B) {
            if (!A.contains(i)) {
                BsubA++;
            }
        }

        System.out.println(AsubB + BsubA);
    }
}
