package com.swea.D2.p1946;

import java.util.*;

public class Solution {
    static int printLimit = 10; // 출력 제한 변수

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            Map<String, Integer> map = new LinkedHashMap<>(N);

            for (int n = 0; n < N; n++) {
                map.put(sc.next(), sc.nextInt());
            }

            List<String> keys = new ArrayList<>(map.keySet());
            int printCnt = 0;

            sb.append("#").append(t).append("\n");
            for (String k : keys) {
                printCnt = map.get(k);

                while (true) {
                    if (printCnt == 0) {
                        break; // 다음 키로
                    } else if (printLimit == 0) {
                        sb.append("\n");
                        printLimit = 10;
                    } else {
                        sb.append(k);
                        printCnt--;
                        printLimit--;
                    }
                }
            }
            sb.append("\n");
            printLimit = 10;
        }

        System.out.println(sb);
        sc.close();
    }
}
