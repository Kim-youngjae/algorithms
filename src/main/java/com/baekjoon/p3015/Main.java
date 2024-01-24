package com.baekjoon.p3015;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Stack<Value> s = new Stack<>();

        long result = 0; // 50만번 반복에 2^31이 입력으로 계속 들어오면 범위를 넘어선다.

        // i 번째가 기준 i 보다 i+1번째 사람이 큰 경우
        // i+1번째 다음부터는 i번째 사람을 볼 수 없음
        for (int i = 0; i < N; i++) {

            int n = sc.nextInt();

            Value v = new Value(n, 1);

            // 자기보다 큰 기준이 나오면 기준을 교체해줘야 함
            while (!s.isEmpty()) {
                if (s.peek().val <= v.val) {
                    result += s.peek().count;
                    if (s.peek().val == v.val) { // 높이가 같은 경우 횟수를 더해줌
                        v.count += s.peek().count;
                    }
                    s.pop();
                } else {
                    break;
                }
            }

            if (!s.isEmpty()) {
                result += 1;
            }

            s.push(v);
        }

        System.out.println(result);
        sc.close();
    }

    static class Value {
        int val;
        int count;

        public Value(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
