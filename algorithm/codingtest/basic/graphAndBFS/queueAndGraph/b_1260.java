package algorithm.codingtest.basic.graphAndBFS.queueAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_1260 {
  static boolean[] visited;
  static int[][] edgeArr;
  static int N;
  static Queue<Integer> queue = new LinkedList<>();
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());
    edgeArr = new int[N+1][N+1];
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      edgeArr[from][to] = edgeArr[to][from] = 1;
    }

    visited = new boolean[N+1];
    dfs(V);
    sb.append("\n");
    visited = new boolean[N+1];
    bfs(V);
    System.out.print(sb);
  }
  public static void dfs(int start) {
    visited[start] = true;
    sb.append(start).append(" ");
    for(int i=1; i<=N; i++) {
      if(edgeArr[start][i]==1 && !visited[i]) {
        dfs(i);
      }
    }
  }
  public static void bfs(int start) {
    // bfs는 start를 offer하고 시작한다.
    queue.offer(start);
    visited[start] = true;
    while (!queue.isEmpty()) {
      start = queue.poll();
      sb.append(start).append(" ");
      for(int i=1; i<=N; i++) {
        if(edgeArr[start][i]==1 && !visited[i]) {
          queue.offer(i);
          visited[i] = true;
        }
      }
    }
  }
}
