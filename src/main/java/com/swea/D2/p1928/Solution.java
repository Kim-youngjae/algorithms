package com.swea.D2.p1928;

import java.util.Base64;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());

        for (int t = 1; t <= T; t++) {
            String encodedLine = br.readLine();
            String decodedStr = new String(Base64.getDecoder().decode(encodedLine));
            System.out.printf("#%d %s\n", t, decodedStr);
        }
    }
}
