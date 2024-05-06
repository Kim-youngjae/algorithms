package com.swea.D3.p8673;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < (int) Math.pow(2, N); i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            sb.append(game(list, 0) + "\n");
        }

        System.out.println(sb);
    }

    static int game(List<Integer> round, int sum) {
        List<Integer> nextRound = new ArrayList<>();

        if (round.size() == 1) {
            return sum;
        }

        int size = round.size();
        for (int i = 0; i < size - 1; i += 2) {
            sum += Math.abs(round.get(i) - round.get(i + 1));
            nextRound.add(Math.max(round.get(i), round.get(i + 1)));
        }

        return game(nextRound, sum);
    }
}
