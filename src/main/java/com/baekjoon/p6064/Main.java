package com.baekjoon.p6064;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int M, N, x, y;

            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            // year의 최대 값은 문제에 나와있는 것처럼 = M, N의 lcm 이다.
            int lcm = M * N / gcd(M, N);

            // 1. year = x의 값으로 처음에 대입해주면서 시작하면
            // 2. year % M == x 는 확정으로 시작한다.
            // 3. 그 이후 year += M 을 해주면서 (2번 문항을 지키기 위해)
            // 4. year % N == y 인 값을 구하면 된다.

            // 이때 12 6 12 6 인 경우(같은 경우)
            // 즉, N == y 인 경우를 보자
            // year = x(12) 일 때
            // year(12) % N(6) == 0이다.
            // y(6)이 아닌 것이다.
            // 체크를 하지 못하기 때문에 이 경우를 체크하는 로직도 추가해야 한다.
            // 나머지 정리 방식을 사용하여 x와 y를 -1 씩 해주고 나중에 year에 +1을 해주면 된다.

            x--;
            y--; // 이게 이해가 안되었음
            int year = x;
            while (year <= lcm) {
                // year % M == x
                // year % N == y
                if (year % N == y) {
                    sb.append(year + 1 + "\n");
                    break;
                }
                year += M;
            }

            if (year > lcm)
                sb.append(-1 + "\n");
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }
}
