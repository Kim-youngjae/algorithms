package com.codeup.p3004;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Sol().run();
    }
}

class Sol {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Data> datum = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            datum.add(new Data(0, sc.nextInt()));
        }

        Comparator<Data> comparator = new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return (o1.value > o2.value) ? 1 : -1;
            }
        };

        ArrayList<Data> results = new ArrayList<>();
        for (Data data : datum) {
            results.add(data);
        }

        Collections.sort(datum, comparator);

        int i = 0;
        for (Data data : datum) {
            data.key = i++;
        }

        for (Data data : results) {
            System.out.printf("%d ", data.key);
        }
    }
}

class Data {
    int key;
    int value;

    public Data(int key, int value) {
        this.key = key;
        this.value = value;
    }
}