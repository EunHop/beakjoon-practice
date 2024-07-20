package algorithm.basic.two.graph.one.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 서울 지하철 2호선
 */
public class b_16947 {
  static int N;
  static ArrayList<ArrayList<Integer>> graph;
  static boolean[] visited, inCycle;
  static int[] parent, distance;
  static boolean isCycle = false;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    graph = new ArrayList<>();
    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }
    for(int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());
      graph.get(node1).add(node2);
      graph.get(node2).add(node1);
    }
    visited = new boolean[N+1];
    inCycle = new boolean[N+1];
    // ex) [ 노드1 -> 노드2 ] 를 의미하는 부모 배열
    parent = new int[N+1];
    findCycle_dfs(1, -1);
    // 최단 거리를 담을 배열
    distance = new int[N+1];
    distance_bfs();
    StringBuilder sb = new StringBuilder();
    for(int i=1; i<=N; i++) {
      sb.append(distance[i]).append(" ");
    }
    System.out.println(sb);
  }
  static void findCycle_dfs(int cur, int prev) {
    // 현재 노드 방문 체크
    visited[cur] = true;
    for(int neighbor : graph.get(cur)) {
      // 방문하지 않았다면, 인접 노드 -> 현재 노드를 의미하는 부모 배열을 통해 노드들의 간선 구조를 만들 수 있다.
      if(!visited[neighbor]) {
        parent[neighbor] = cur;
        // 재귀를 통해 다음 노드로 넘어갑니다.
        findCycle_dfs(neighbor, cur);
        if(isCycle) return;
        // 방문했었는데 바로 전에 확인한 노드가 아니라면, 사이클을 찾았다는 의미
      } else if(neighbor != prev && !isCycle) {
        int temp = cur;
        inCycle[temp] = true;
        // 해당 코드로 인해 순환열에 있는 노드들을 모두 찾는다.
        // 보니까 약간 백트래킹 같기도...
        while(temp != neighbor) {
          temp = parent[temp];
          inCycle[temp] = true;
        }
        isCycle = true;
        return;
      }
    }
  }
  static void distance_bfs() {
    Queue<Integer> queue = new LinkedList<>();
    Arrays.fill(distance, -1);
    for(int i=1; i<=N; i++) {
      if(inCycle[i]) {
        distance[i] = 0;
        queue.add(i);
      }
    }
    while(!queue.isEmpty()) {
      int cur = queue.poll();
      for(int neighbor : graph.get(cur)) {
        if(distance[neighbor] == -1) {
          distance[neighbor] = distance[cur] + 1;
          queue.add(neighbor);
        }
      }
    }
  }
}
