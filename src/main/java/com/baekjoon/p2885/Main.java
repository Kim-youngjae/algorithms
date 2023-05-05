package com.baekjoon.p2885;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //해당 수보다 크고 제일 작은 제곱 수를 구해야 한다.
        // 입력이 6이 들어왔으면 6보다 크고 제일 작은 제곱수는 8이 된다.
        // 8을 한번 나누면 4, 4 이걸로 더해서 6을 만들 수 없으면 다시 쪼갠다.
        // 2,2,2,2 3번을 더하다 보면 6이 된다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()); // 만들어야 하는 초콜릿 수

        // K보다 크고 그 수가 제곱인 수를 찾아야 함
        long choco = 1; // 1부터 시작해서 K보다 작으면 계속 2를 곱해준다.

        while (K > choco) {
            choco *= 2;
        }

        System.out.printf("%d", choco);

        int n = 0; // 바로 나누어 떨어지면 안쪼개도 된다

        // K개를 만들 수 있다는 것은 반으로 나눈 값이 정확하게 나누어 떨어짐
        while (true) {
            if (K % choco == 0) {
                System.out.printf(" %d", n); // 나눠 떨어지면 쪼갠 반복 횟수가 최소의 초콜릿 크기
                break;
            } else {
                choco /= 2;
                n += 1; //
            }
        }
    }
}

