package com.programmers.level0.p120838;

//https,//school.programmers.co.kr/learn/courses/30/lessons/120838

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String letter) {
        Map<String, String> morse = new HashMap<>() {{
            put(".-","a");
            put("-...","b");
            put("-.-.","c");
            put("-..","d");
            put(".","e");
            put("..-.","f");
            put("--.","g");
            put("....","h");
            put("..","i");
            put(".---","j");
            put("-.-","k");
            put(".-..","l");
            put("--","m");
            put("-.","n");
            put("---","o");
            put(".--.","p");
            put("--.-","q");
            put(".-.","r");
            put("...","s");
            put("-","t");
            put("..-","u");
            put("...-","v");
            put(".--","w");
            put("-..-","x");
            put("-.--","y");
            put("--..","z");
        }};

        StringBuilder sb = new StringBuilder();

        String[] bits = letter.split(" ");

        for (String s : bits) {
            sb.append(morse.get(s));
        }

        return sb.toString();
    }
}


