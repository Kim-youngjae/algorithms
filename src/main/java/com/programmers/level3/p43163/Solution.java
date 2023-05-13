package com.programmers.level3.p43163;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[] visited;
    static int ans = 0;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        // words 길이 만큼 방문해야 함
        visited = new boolean[words.length];

        bfs(begin, target, words);

        answer = ans;

        return answer;
    }

    private void bfs(String begin, String target, String[] words) {
        // 같지 않으면 다음 로직 수행
        Queue<Procedure> q = new LinkedList<>();

        q.add(new Procedure(0, begin));

        while (!q.isEmpty()) {
            // 큐가 비어있지 않은동안
            Procedure current = q.poll();

            // begin 랑 target 이랑 같으면 종료
            if (current.word.equals(target)) {
                ans = current.depth; // 이미 Procedure 안에 depth 필드가 있다.
                return;
            }

            for (int i = 0; i < words.length; i++) {
                int diff = 0; // 다른 부분이 1개인지 아닌지 세기 위함

                for (int j = 0; j < begin.length(); j++) {
                    if (current.word.charAt(j) != words[i].charAt(j)) {
                        diff++;
                    }
                }

                if (!visited[i] && diff == 1) { // 방문하지 않았거나, 다른 부분이 1개라면
                    visited[i] = true;
                    q.add(new Procedure(current.depth + 1, words[i]));
                }
            }
        }
    }
}

class Procedure {
    int depth;
    String word;

    public Procedure(int depth, String word) {
        this.depth = depth;
        this.word = word;
    }
}