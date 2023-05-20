package com.baekjoon.p15787;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] train;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        train = new int[N][20];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int type = Integer.parseInt(st.nextToken());
            int trainNum = Integer.parseInt(st.nextToken()) - 1; // 0 ~ 19

            if (type == 1) {
                // 1 i x : i번째 기차에(1 ≤ i ≤ N) x번째 좌석에(1 ≤ x ≤ 20) 사람을 태워라. 이미 사람이 타있다면, 아무런 행동을 하지 않는다.
                int seatNum = Integer.parseInt(st.nextToken()) - 1;
                train[trainNum][seatNum] = 1;
            } else if (type == 2) {
                int seatNum = Integer.parseInt(st.nextToken()) - 1;
                train[trainNum][seatNum] = 0;
            } else if (type == 3) {
                // 3 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 뒤로간다. k번째 앉은 사람은 k+1번째로 이동하여 앉는다. 만약 20번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
                moveToBackSeat(trainNum);
            } else if (type == 4) {
                // 4 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로간다. k번째 앉은 사람은 k-1 번째 자리로 이동하여 앉는다. 만약 1번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
                moveToFrontSeat(trainNum);
            }
        }

        for (int i = 0; i < N; i++) {
            set.add(Arrays.toString(train[i]));
        }

        System.out.println(set.size());
    }

    private static void moveToBackSeat(int trainNum) {
        for (int i = 18; i >= 0; i--) { // 18 ~ 0
            train[trainNum][i + 1] = train[trainNum][i]; // 19,18 18,17 ,,, 2,1 1,0
        }
        train[trainNum][0] = 0;
    }

    private static void moveToFrontSeat(int trainNum) {
        for (int i = 1; i < 20; i++) { // 1 ~ 19
            train[trainNum][i - 1] = train[trainNum][i]; // 0,1 1,2 2,3 ,,, 18,19
        }
        train[trainNum][19] = 0;
    }
}
