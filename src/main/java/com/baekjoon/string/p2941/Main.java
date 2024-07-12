package com.baekjoon.string.p2941;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int cnt = 0;
        int len = str.length();

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);

            if (now == 'c' && i < len - 1) {
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                }
            }

            else if (now == 'd' && i < len - 1) {
                if (str.charAt(i + 1) == '-') {
                    i++;
                } else if (str.charAt(i + 1) == 'z' && i < len - 2) {
                    if (str.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            }

            else if ((now == 'l' || now == 'n') && i < len - 1) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            }

            else if ((now == 's' || now == 'z') && i < len - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            }

            cnt++;
        }

        System.out.print(cnt);
    }
}
