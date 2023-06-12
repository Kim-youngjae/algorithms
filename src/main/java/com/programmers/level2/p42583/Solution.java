package com.programmers.level2.p42583;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(2, 10, new int[]{7, 4, 5, 6}));
    }

    static int TIME;
    static int TOTAL_WEIGHT;

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();

        TIME = 0;
        TOTAL_WEIGHT = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            while (true) {
                if (q.isEmpty()) {
                    q.add(truck);
                    TOTAL_WEIGHT += truck;
                    TIME += 1;
                    break;
                }
                // 처음 올리기 전에 다리가 꽉 찼는지 하중을 견딜 수 있는지 체크
                else if (q.size() == bridge_length) {
                    int crossed = q.poll();
                    TOTAL_WEIGHT -= crossed;
                }
                else {
                    if (weight < TOTAL_WEIGHT + truck) {
                        q.add(0); // 0을 넣어서 다리를 건너도록
                        TIME++;
                    } else { // 하중을 견딜 수 있으면
                        q.add(truck);
                        TIME += 1;
                        TOTAL_WEIGHT += truck;
                        break;
                    }
                }
            }
        }

        TIME += bridge_length;

        return TIME;
    }
}

class Solution2 {
    public static void main(String[] args) {

    }

    static int TOTAL_WEIGHT = 0; // 트럭의 총 무게
    static int TIME = 0;

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i]; // 트럭 (무게)

            while (true) {
                if (bridge.isEmpty()) {
                    // 다리가 비어 있으면
                    bridge.add(truck); // 다리에 트럭 진입
                    TOTAL_WEIGHT += truck; //진입하면 트럭 무게 만큼 총 중량 증가
                    TIME += 1; // 트럭이 다리에 올라간 시점 부터 시간++
                    break; // 멈추고 그 다음 트럭 확인하기
                }
                else if (bridge.size() == bridge_length) {
                    // 다리에 모든 트럭이 차있을 때
                    int crossedTruck = bridge.poll();
                    TOTAL_WEIGHT -= crossedTruck;
                }
                else { // 다리에 트럭이 있는 경우
                    // 트럭이 다리에 올라갈 수 있는지 없는지 판단
                    if (TOTAL_WEIGHT + truck <= weight) {
                        bridge.add(truck);
                        TOTAL_WEIGHT += truck;
                        TIME += 1;
                        break;
                    }
                    else { // 다리에 모든 트럭이 차있지 않지만 총 하중이 제한하중을 넘어 더 이상 트럭이 올라갈 수 없는 경우
                        bridge.add(0); // 0을 넣어 다리에서 트럭이 움직이도록
                        TIME += 1;
                    }
                }
            }
        }

        return TIME + bridge_length; //

    }
}