package com.baekjoon.p1620;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> stringIndexBook = new HashMap<>(N);
        Map<Integer, String> numberIndexBook = new HashMap<>(N);

        for (int i = 1; i <= N; i++) {
            String pokemonName = br.readLine();
            stringIndexBook.put(pokemonName, i);
            numberIndexBook.put(i, pokemonName);
        }

        for (int i = 0; i < M; i++) {
            String question = br.readLine();

            if (Character.isDigit(question.charAt(0))) {
                sb.append(numberIndexBook.get(Integer.parseInt(question)) + "\n");
            } else {
                sb.append(stringIndexBook.get(question) + "\n");
            }
        }

        System.out.println(sb);
    }
}
