package algorithm.basic.two.graph.one.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BFS 스페셜 저지
 */
public class b_16940 {
  static ArrayList<ArrayList<Integer>> graph;
  static boolean[] visited;
  static int[] order;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
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
    visited = new boolean[N+1];
    order = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      order[i] = Integer.parseInt(st.nextToken());
    }
    if(bfs()) System.out.println(1);
    else System.out.println(0);
  }
  static boolean bfs() {
    if(order[0] != 1) return false;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    visited[1] = true;
    int index = 1;
    while(!queue.isEmpty()) {
      int cur = queue.poll();
      HashSet<Integer> set = new HashSet<>();
      for(int next : graph.get(cur)) {
        if(!visited[next]) {
          visited[next] = true;
          set.add(next);
        }
      }
      for(int i=0; i<set.size(); i++) {
        if(index < N && set.contains(order[index])) {
          queue.add(order[index]);
          index++;
        }
        else return false;
      }
    }
    return index == N;
  }
}
