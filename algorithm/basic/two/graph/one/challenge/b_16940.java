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

    // 인접 리스트로 그래프 생성
    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 1; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());
      graph.get(node1).add(node2);
      graph.get(node2).add(node1);
    }

    visited = new boolean[N + 1];
    // 마지막에 주어진 방문 순서 저장
    order = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      order[i] = Integer.parseInt(st.nextToken());
    }

    if (bfs()) System.out.println(1);
    else System.out.println(0);
  }

  static boolean bfs() {
    // 주어진 방문 순서가 처음에 1로 시작해야한다.
    if (order[0] != 1) return false;

    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    visited[1] = true;
    // index 변수를 증가시키는 식으로 order[] 의 순서를 확인한다.
    int index = 1;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      HashSet<Integer> set = new HashSet<>();
      for (int next : graph.get(cur)) {
        if (!visited[next]) {
          visited[next] = true;
          set.add(next);
        }
      }
      // 담겨져있는 HashSet 의 사이즈만큼 확인한다.
      for (int i = 0; i < set.size(); i++) {
        if (index < N && set.contains(order[index])) {
          queue.add(order[index]);
          index++;
        } else return false;
      }
    }
    return index == N;
  }
}
