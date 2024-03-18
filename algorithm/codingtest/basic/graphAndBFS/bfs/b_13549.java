package algorithm.codingtest.basic.graphAndBFS.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_13549 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    BFS(N, K);
  }
  public static void BFS(int N, int K) {
    Queue<Node> queue = new LinkedList<>();
    boolean[] visited = new boolean[100_001];
    queue.offer(new Node(N, 0));
    visited[N] = true;
    while (!queue.isEmpty()) {
      Node cur = queue.poll();
      if (cur.position == K) {
        System.out.println(cur.time);
        return;
      }
      if (cur.position * 2 <= 100_000 && !visited[cur.position * 2]) {
        queue.offer(new Node(cur.position * 2, cur.time));
        visited[cur.position * 2] = true;
      }
      // -1 을 +1 보다 먼저 해야 최소 시간을 구할 수 있다.
      for(int next : new int[]{cur.position-1, cur.position+1}) {
        if (next >= 0 && next <= 100_000 && !visited[next]) {
          queue.offer(new Node(next, cur.time + 1));
          visited[next] = true;
        }
      }
    }
  }
  public static class Node {
    int position;
    int time;

    public Node(int position, int time) {
      this.position = position;
      this.time = time;
    }
  }
}
