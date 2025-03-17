package com.baekjoon.hash.p26069;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Set<String> dancingUser = new HashSet<>();
        dancingUser.add("ChongChong");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String userA = st.nextToken();
            String userB = st.nextToken();

            if (dancingUser.contains(userA) || dancingUser.contains(userB)) {
                dancingUser.add(userA);
                dancingUser.add(userB);
            }
        }

        System.out.println(dancingUser.size());

    }
}
