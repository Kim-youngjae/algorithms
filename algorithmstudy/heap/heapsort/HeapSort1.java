package algorithmstudy.heap.heapsort;

import java.util.*;

public class HeapSort1 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] x;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        x = new int[N];

        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
        }

        sb.append("정렬되기전 배열 : ");
        for (int i = 0; i < N; i++) {
            sb.append(x[i] + " ");
        }
        sb.append("\n");

        heapSort(x, N);

        sb.append("정렬 후 배열 : ");
        for (int i = 0; i < N; i++) {
            sb.append(x[i] + " ");
        }

        System.out.println(sb);
        sc.close();
    }

    // 요소 변경 메서드
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // left ~ right 를 힙 상태로 만드는 메서드
    static void downHeap(int[] a, int left, int right) {
        int temp = a[left]; // 루트
        int child;
        int parent;

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1; // 왼쪽 자식 인덱스
            int cr = cl + 1; // 오른쪽 자식 인덱스
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;

            if (temp >= a[child]) { // 루트 값이 자식보다 크면 힙 상태를 만족하므로 반복 종료
                break;
            }
            a[parent] = a[child];
        }

        a[parent] = temp;

        sb.append("정렬 중인 배열 : ");
        for (int i = 0; i < N; i++) {
            sb.append(x[i] + " ");
        }
        sb.append("\n");
    }

    static void heapSort(int[] a, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            downHeap(a, i, n - 1);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            downHeap(a, 0, i - 1);
        }
    }
}
