package com.baekjoon.data_structure.p1043;

import java.io.*;
import java.util.*;

public class Main {
    static int[] members;
    static List<Integer> factMembers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int fn = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수

        if (fn == 0) {
            System.out.println(M);
            return;
        } else {

            for (int i = 0; i < fn; i++) {
                factMembers.add(Integer.parseInt(st.nextToken()));
            }
        }

        members = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            members[i] = i;
        }

        List<List<Integer>> partyList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            partyList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int pn = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            partyList.get(i).add(x);

            for (int j = 1; j < pn; j++) {
                int y = Integer.parseInt(st.nextToken());
                partyList.get(i).add(y);
                union(x, y);
            }
        }

        int cnt = 0;

        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int x : partyList.get(i)) {
                if (factMembers.contains(find(members[x]))) {
                    canLie = false;
                    break;
                }
            }

            if (canLie) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    static int find(int x) {
        if (x == members[x]) {
            return x;
        } else {
            return members[x] = find(members[x]);
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (factMembers.contains(y)) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        members[y] = x;
    }
}
