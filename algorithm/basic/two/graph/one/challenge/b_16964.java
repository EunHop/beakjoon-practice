package algorithm.basic.two.graph.one.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_16964 {
  static ArrayList<ArrayList<Integer>> graph;
  static boolean[] visited;
  static int[] dfsOrder;
  static int index = 1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    graph = new ArrayList<>();
    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }
    for(int i=1; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());
      graph.get(node1).add(node2);
      graph.get(node2).add(node1);
    }

    // 주어진 dfs 순서를 배열로 담습니다.
    // 그래프를 dfs 하면서 해당 위치에 dfs 순서가 올바른지 판별하기 위해 사용합니다.
    dfsOrder = new int[N+1];

    // order[] 배열은 노드 번호를 index 로 가지고 해당 노드의 위치를 값으로 가집니다. ex) order[node1] = 위치;
    // 따라서 노드 번호들의 순서 차이로 인접 리스트를 정렬할 수 있습니다.
    int[] order = new int[N+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; i++) {
      dfsOrder[i] = Integer.parseInt(st.nextToken());
      order[dfsOrder[i]] = i;
    }
    if(dfsOrder[1] != 1) {
      System.out.println(0);
      return;
    }

    for(int i=1; i<=N; i++) {
      //graph.get(i).sort(Comparator.comparingInt(a -> order[a]));
      graph.get(i).sort((a, b) -> order[a] - order[b]);
    }

    visited = new boolean[N+1];
    if(dfs(1)) System.out.println(1);
    else System.out.println(0);
  }

  static boolean dfs(int x) {
    visited[x] = true;
    if(dfsOrder[index++] != x) return false;
    for(int next : graph.get(x)) {
      if(!visited[next] && !dfs(next)) return false;
    }
    return true;
  }
}
