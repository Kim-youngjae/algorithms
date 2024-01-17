package com.baekjoon.p16165;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<String, String> store = new LinkedHashMap<>();

        while (N-- > 0) {
            String groupName = sc.next();

            int num = sc.nextInt();

            while (num-- > 0) {
                String memberName = sc.next();
                store.put(memberName, groupName);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            String quiz = sc.next();
            int type = sc.nextInt();

            switch (type) {
                case 0:
                    List<String> keys = new ArrayList<>(store.keySet());
                    Collections.sort(keys);
                    for (String key : keys) {
                        if (store.get(key).equals(quiz)) {
                            sb.append(key + "\n");
                        }
                    }
                    break;

                case 1:
                    sb.append(store.get(quiz) + "\n");
                    break;
            }
        }

        System.out.println(sb);
        sc.close();
    }
}
