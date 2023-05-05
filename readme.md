# 자주 쓰이고 알아두면 좋은 알고리즘 정리

**BFS 알고리즘 기본적인 틀**

---

```java
private static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();

    q.add(start);
    visited[start] = true;

    while (!q.isEmpty()) {

        int node = q.poll();
        System.out.printf("%d ", node + 1);

        for (int i = 0; i < visited.length; i++) {
            if (nodes[node][i] == 1 && !visited[i]) {
                q.add(i);
                visited[i] = true;
            }
        }
    }
}
```

**DFS 알고리즘 기본 틀**

---

```java
private static void dfs(int start) {
    // 방문한 노드는 출력
    System.out.printf("%d ", start + 1);
    visited[start] = true;

    for (int i = 0; i < visited.length; i++) {
        if (nodes[start][i] == 1 && !visited[i]) {
            dfs(i);
        }
    }
}
```

