package com.baekjoon.data_structure.p1717;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 입력
        parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd.equals("0")) {
                union(a, b);
            } else {
                if (isUnion(a, b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.println(sb);
    }

    // 부모를 찾는 함수
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    // a, b가 포함된 집합을 합치는 메서드
    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            /*
             * 일반적으로 작은 값이 부모가 되는 쪽으로 합친다.
             */
            if (a < b) {
                parent[a] = b;
            } else {
                parent[b] = a;
            }
        }
    }

    // 같은 부모인지 확인하는 함수
    static boolean isUnion(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            return false;
        } else {
            return true;
        }
    }
}
