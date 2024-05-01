package algorithmstudy.최단거리알고리즘.dijkstra;

import java.io.*;
import java.util.*;

public class Dijkstra {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int start = Integer.parseInt(st.nextToken()); // 시작 정점

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>()); // 그래프 초기화
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, cost));
        }

        dijkstra(start);
    }

    static void dijkstra(int start) {
        boolean[] v = new boolean[N + 1]; // 방문 체크 배열
        int[] dist = new int[N + 1]; // 거리를 체크할 배열
        int INF = 10000001;

        Arrays.fill(dist, INF);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            int nowVertex = pq.poll().index; // 우선순위 큐에서 뽑은 정점

            if (v[nowVertex]) { // 정점이 이미 방문한 노드라면 거리 체크 안함
                continue;
            }
            v[nowVertex] = true;

            for (Node next : graph.get(nowVertex)) {
                if (dist[next.index] > dist[nowVertex] + next.cost) {
                    dist[next.index] = dist[nowVertex] + next.cost;

                    pq.add(new Node(next.index, dist[next.index]));
                }
            }
        }

        // 큐가 비어서 더 이상 탐색할 곳이 없으면 지금까지 계산한 최소 거리 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(dist[i] + " ");
        }

    }
}

class Node {
    int index; // 정점을 저장
    int cost; // 정점에 대한 비용을 저장

    Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
}