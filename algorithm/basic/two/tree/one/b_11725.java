package algorithm.basic.two.tree.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 트리의 부모 찾기
 */
public class b_11725 {
  static ArrayList<ArrayList<Integer>> tree;
  static int[] parent;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    tree = new ArrayList<>();
    for(int i=0; i<=N; i++) {
      tree.add(new ArrayList<>());
    }
   for(int i=0; i<N-1; i++) {
     StringTokenizer st = new StringTokenizer(br.readLine());
     int node1 = Integer.parseInt(st.nextToken());
     int node2 = Integer.parseInt(st.nextToken());
     tree.get(node1).add(node2);
     tree.get(node2).add(node1);
   }
   // 각 노드의 부모를 저장할 변수
   parent = new int[N+1];
   searchParentBFS();

   for(int i=2; i<=N; i++) {
     System.out.println(parent[i]);
   }
  }

  // BFS 로 부모 노드를 탐색
  static void searchParentBFS() {
    Queue<Integer> queue = new LinkedList <>();
    queue.add(1);
    parent[1] = 1;
    while(!queue.isEmpty()) {
      int cur = queue.poll();
      for(int child : tree.get(cur)) {
        // child 노드에 대해서 아직 부모 노드가 정해지지 않았다면
        if(parent[child] == 0) {
          parent[child] = cur;
          queue.add(child);
        }
      }
    }
  }
}
