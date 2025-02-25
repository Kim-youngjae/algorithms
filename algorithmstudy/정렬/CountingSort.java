package algorithmstudy.정렬;

/**
 * 
 * array 크기 (수열의 크기)는 100, 수의 범위는 30
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] array = new int[100]; // 수열의 원소 = 100
        int[] counting = new int[31]; // 수의 범위 = 0 ~ 30
        int[] result = new int[100]; // 정렬될 배열

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 31); // 0 ~ 30
        }

        // Counting Sort
        // 과정 1
        for (int i = 0; i < array.length; i++) {
            // array의 값을 index로 하는 counting 배열 값 1증가
            counting[array[i]]++;
        }

        // 과정 2
        for (int i = 1; i < counting.length; i++) {
            // 누적합 해주기
            counting[i] += counting[i - 1];
        }

        // 과정 3
        for (int i = array.length - 1; i >= 0; i--) {
            /**
             * i번째 값을 인덱스로 하는 counting 배열을 1감소시키고
             * counting 배열의 값을 인덱스로 하는 result에 value 값을 저장
             */
            int value = array[i];
            counting[value]--;
            result[counting[value]] = value;
        }

        /* 비교 출력 */

        // 초기 배열
        System.out.println("array[]");
        for (int i = 0; i < array.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(array[i] + "\t");
        }
        System.out.println("\n\n");

        // Counting 배열
        System.out.println("counting[]");
        for (int i = 0; i < counting.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(counting[i] + "\t");
        }
        System.out.println("\n\n");

        // 정렬된 배열
        System.out.println("result[]");
        for (int i = 0; i < result.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(result[i] + "\t");
        }
        System.out.println("\n\n");

        int[] arr = new int[101];

        for (int i = 0; i < 50; i++) {
            arr[(int) (Math.random() * 101)]++;
        }

        for (int i = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                System.out.print(i + " ");
            }
        }
    }
}
