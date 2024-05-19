package com.baekjoon.p2477;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        int maxWidth = 0, maxHeight = 0, d, maxWidthIdx = 0, maxHeightIdx = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());
            // 최대 가로길이 구하기
            if ((d == 1 || d == 2) && maxWidth < arr[i]) { // 가로방향이면서 최대 길이를 만족할 때만 최대 가로길이로 갱신
                maxWidth = arr[i];
                maxWidthIdx = i;
            }
            // 최대 세로길이 구하기
            else if ((d == 3 || d == 4) && maxHeight < arr[i]) { // 세로방향이면서 최대 길이를 만족할 때만 최대 세로길이로 갱신
                maxHeight = arr[i];
                maxHeightIdx = i;
            }
        }

        int right, left, minWidth, minHeight;
        // 빈사각형 가로 세로 구하기
        if (maxWidthIdx + 1 == 6)
            right = 0;
        else
            right = maxWidthIdx + 1;

        if (maxWidthIdx - 1 == -1)
            left = 5;
        else
            left = maxWidthIdx - 1;

        minHeight = Math.abs(arr[right] - arr[left]);

        if (maxHeightIdx + 1 == 6)
            right = 0;
        else
            right = maxHeightIdx + 1;

        if (maxHeightIdx - 1 == -1)
            left = 5;
        else
            left = maxHeightIdx - 1;

        minWidth = Math.abs(arr[right] - arr[left]);

        System.out.println(((maxWidth * maxHeight) - (minWidth * minHeight)) * N);
    }
}
