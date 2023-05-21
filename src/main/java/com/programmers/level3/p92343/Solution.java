package com.programmers.level3.p92343;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        new Solution().solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}});
    }

    static int[] nodeInfo; // info 를 전역 변수로 사용하기 위한 변수
    static ArrayList<Integer>[] children; // 해당 인덱스의 자식 노드를 담고 있을 배열
    static int MAX_SHEEP_CNT = Integer.MIN_VALUE;

    public int solution(int[] info, int[][] edges) {
        int answer = 0;

        nodeInfo = info; // 해당 노드가 양인지 늑대인지에 대한 정보

        children = new ArrayList[info.length]; // 각 부모 노드와 연결된 자식 노드 정보

        // 부모 - 자식 노드 관계 초기화
        for (int[] edge : edges) {
            int parent = edge[0]; // 부모 노드 번호
            int child = edge[1]; // 자식 노드 번호

            if (children[parent] == null) { // 부모 노드가 없으면
                children[parent] = new ArrayList<>(); // 새로 생성하고 자식 노드 연결
            }
            children[parent].add(child);
        }


        List<Integer> list = new ArrayList<>();
        list.add(0); // 루트 노드 부터 시작
        dfs(0, 0, 0, list);

        System.out.println(MAX_SHEEP_CNT);

        answer = MAX_SHEEP_CNT;

        return answer;
    }

    private void dfs(int idx, int sheepCnt, int wolfCnt, List<Integer> nextPos) {
        if (nodeInfo[idx] == 0) { // 양이라면
            sheepCnt += 1;
        } else {
            wolfCnt += 1;
        }

        if (sheepCnt <= wolfCnt) { // 양이랑 늑대의 수가 같거나 늑대 수가 많아지면 종료
            return;
        }

        MAX_SHEEP_CNT = Math.max(MAX_SHEEP_CNT, sheepCnt); // 종료 조건에 해당되지 않으면 최대 값 갱신

        List<Integer> list = new ArrayList<>();
        list.addAll(nextPos);
        list.remove(Integer.valueOf(idx)); // 목록에서 현재 위치는 제거하기 (방문 했기 때문에)

        if (children[idx] != null) {
            for (int childNode : children[idx]) { // 해당 부모 노드와 연결된 자식 노드들을 리스트에 저장
                list.add(childNode);
            }
        }

        for (int nextNode : list) { // 갈 수 있는 모든 노드들을 탐색
            dfs(nextNode, sheepCnt, wolfCnt, list);
        }
    }
}
