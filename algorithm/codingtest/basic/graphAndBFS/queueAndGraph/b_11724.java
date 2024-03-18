package algorithm.codingtest.basic.graphAndBFS.queueAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_11724 {
  static int[][] edgeArr;
  static boolean[] visited;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    edgeArr = new int[N+1][N+1];
    visited = new boolean[N+1];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      // 무뱡향 그래프이므로 edgeArr[u][v]랑 edgeArr[v][u]를 1로 해줘야함.
      edgeArr[u][v] = 1;
      edgeArr[v][u] = 1;
    }
    int count = 0;
    for(int i=1; i<=N; i++) {
      if(!visited[i]) {
        dfs(i);
        count++;
      }
    }
    System.out.println(count);
  }
  public static void dfs(int depth) {
    if(visited[depth]) {
      return;
    }
    visited[depth] = true;
    for (int i=1; i<=N; i++) {
      if(edgeArr[depth][i] == 1) {
        dfs(i);
      }
    }
  }
}
