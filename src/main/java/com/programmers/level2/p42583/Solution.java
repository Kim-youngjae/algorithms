package com.programmers.level2.p42583;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();

        int total = 0;
        int time = 0;

        // 큐가 비어있지 않은 동안 반복
        for (int truck : truck_weights) {

            A: while (true) {

                if (bridge.isEmpty()) {
                    total += truck;
                    bridge.offer(truck);
                    time++;
                    break A;
                } else if (bridge.size() == bridge_length) {
                    total -= bridge.poll();
                } else {
                    if (total + truck <= weight) {
                        total += truck;
                        bridge.offer(truck);
                        time++;
                        break A;
                    } else {
                        // 총 무게 + 새로운 트럭이 되면 다리 최대 하중을 넘어서서 다리에 남아 있는 트럭이 움직일 수 있도록 해주어야 한다.
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }

        answer = time + bridge_length;

        return answer;
    }
}