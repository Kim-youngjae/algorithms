package com.baekjoon.p1543;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String word = br.readLine();

        int wholeLength = document.length();
        int changedLength = 0;

        document = document.replace(word, "");

        changedLength = wholeLength - document.length(); // 변경된 길이

        System.out.println(changedLength / word.length());
    }
}
