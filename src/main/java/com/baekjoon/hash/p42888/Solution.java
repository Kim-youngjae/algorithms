package com.baekjoon.hash.p42888;

import java.util.*;

public class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};

        Map<String, String> nickNameMap = new HashMap<>();
        List<Record> recordList = new ArrayList<>();

        for (String info : record) {
            String[] infoArr = info.split(" ");

            switch (infoArr[0]) {
                case "Enter":
                    String userId = infoArr[1];
                    String nickName = infoArr[2];

                    nickNameMap.put(userId, nickName); // 유저아이디 : 닉네임
                    recordList.add(new Record(userId, "님이 들어왔습니다."));
                    break;
                case "Leave":
                    userId = infoArr[1];
                    recordList.add(new Record(userId, "님이 나갔습니다."));
                    break;
                case "Change":
                    userId = infoArr[1];
                    nickName = infoArr[2];
                    nickNameMap.put(userId, nickName); // 유저아이디 : 닉네임
                    break;
            }
        }

        answer = new String[recordList.size()];

        for (int i = 0; i < recordList.size(); i++) {
            StringBuilder sb = new StringBuilder();
            Record r = recordList.get(i);
            sb.append(nickNameMap.get(r.id)).append(r.io);
            answer[i] = sb.toString();
        }
        return answer;
    }

    static class Record {
        String id;
        String io;

        Record(String id, String io) {
            this.id = id;
            this.io = io;
        }
    }
}
