package com.codeup.p1805;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        new Solution1().run();
        new Solution2().run();
    }
}

class Solution1 {
    public void run() {
        ArrayList<Device> devices = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int gas = sc.nextInt();
            devices.add(new Device(id, gas));
        }

        Comparator<Device> comparator = new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                if (o1.id > o2.id) {
                    return 1;
                } else if (o1.id < o2.id) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        Collections.sort(devices, comparator);

        for (Device d : devices) {
            System.out.printf("%d %d\n", d.id, d.gas);
        }
    }
}

class Device{
    int id;
    int gas;

    Device(int id, int gas) {
        this.id = id;
        this.gas = gas;
    }
}

class Solution2 { // Map으로 풀어보기
    public void run() {
        Map<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            map.put(sc.nextInt(), sc.nextInt());
        }

        List<Integer> myKeySet = new ArrayList<>(map.keySet());

        Collections.sort(myKeySet);

        for (Integer key : myKeySet) {
            System.out.printf("%d %d\n", key, map.get(key));
        }
    }
}