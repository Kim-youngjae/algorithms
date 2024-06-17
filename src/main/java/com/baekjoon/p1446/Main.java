package com.baekjoon.p1446;

import java.io.*;
import java.util.*;

public class Main {
    static int N, D;

    static class Shortcut {
        int from, to, cost;

        Shortcut(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        /**
         * 첫째 줄에 지름길의 개수 N과 고속도로의 길이 D가 주어진다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        List<Shortcut> shortcuts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            /**
             * 역주행을 할 수 없으므로 도착지점이 D를 넘어가면 입력 x
             */
            if (to > D) {
                continue;
            }

            /**
             * 지름길이 그냥 가는 길보다 더 길면 지름일로 입력 x
             */
            if (to - from > cost) {
                shortcuts.add(new Shortcut(from, to, cost));
            }
        }

        int idx = 0, move = 0;
        int[] dist = new int[D + 1];

        Arrays.fill(dist, 10001);
        dist[0] = 0;

        Collections.sort(shortcuts, new Comparator<Shortcut>() {
            public int compare(Shortcut s1, Shortcut s2) {
                if (s1.from == s2.from) {
                    return Integer.compare(s1.to, s2.to);
                }

                return Integer.compare(s1.from, s2.from);

            }
        });

        while (move < D) {
            if (idx < shortcuts.size()) {
                Shortcut path = shortcuts.get(idx);
                if (path.from == move) {
                    dist[path.to] = Math.min(dist[move] + path.cost, dist[path.to]);
                    idx++;
                } else {
                    dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
                    move++;
                }
            } else {
                dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
                move++;
            }
        }

        System.out.println(dist[D]);
    }
}
