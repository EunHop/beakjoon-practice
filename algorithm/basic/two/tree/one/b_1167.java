package algorithm.basic.two.tree.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 트리의 지름
 */
public class b_1167 {
  static boolean[] visited;
  static ArrayList<ArrayList<Node>> tree;
  static int maxDistance, farthestNode;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int V = Integer.parseInt(br.readLine());
    tree = new ArrayList<>();
    for(int i=0; i<=V; i++) {
      tree.add(new ArrayList<>());
    }
    for(int i=0; i<V; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      while(true) {
        int to = Integer.parseInt(st.nextToken());
        if(to == -1) {
          break;
        }
        int weight = Integer.parseInt(st.nextToken());
        tree.get(from).add(new Node(to, weight));
      }
    }
    // 루트 노드에서 가장 먼 노드를 찾는다.
    visited = new boolean[V+1];
    maxDistance = 0;
    farthestNode = 0;
    searchFarthestNodeDFS(1, 0);

    // 가장 먼 노드에서 반대쪽 가장 먼 노드를 찾는다.
    // 이진 트리로 설명하자면 가장 먼 노드가 왼쪽 트리를 타고 들어갔다면,
    // 반대쪽 가장 먼 노드는 오른쪽 트리를 타고 들어가 가장 먼 노드를 찾는 것이다.
    // 루트 노드보다 더 먼 노드가 존재할 수 있기 때문에 DFS 를 두번 탐색하는 것이다.
    visited = new boolean[V+1];
    maxDistance = 0;
    searchFarthestNodeDFS(farthestNode, 0);
    System.out.println(maxDistance);
  }
  static class Node {
    int to;
    int weight;
    public Node(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }
  static void searchFarthestNodeDFS(int node, int distance) {
    if(visited[node]) {
      return;
    }
    visited[node] = true;
    if(maxDistance<distance) {
      maxDistance = distance;
      farthestNode = node;
    }
    for(Node child : tree.get(node)) {
      if(!visited[child.to]) {
        searchFarthestNodeDFS(child.to, distance+child.weight);
      }
    }
  }
}
