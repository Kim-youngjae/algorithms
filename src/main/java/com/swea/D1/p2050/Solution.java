package com.swea.D1.p2050;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String alphabet = sc.nextLine();

        for (int i = 0; i < alphabet.length(); i++) {
            System.out.printf("%d ", alphabet.charAt(i) - 'A' + 1);
        }

        sc.close();
    }

}