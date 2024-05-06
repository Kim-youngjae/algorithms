package com.swea.D3.p7728;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            Set<Integer> set = new HashSet<>();
            String target = br.readLine();

            for (int i = 0; i < target.length(); i++) {
                set.add(target.charAt(i) - '0');
            }

            sb.append(set.size() + "\n");
        }

        System.out.println(sb);
    }
}
