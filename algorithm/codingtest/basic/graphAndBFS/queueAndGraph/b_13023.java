package algorithm.codingtest.basic.graphAndBFS.queueAndGraph;

// https://minhamina.tistory.com/50

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b_13023 {
  static ArrayList<Integer>[] edgeList;
  static boolean[] visited;
  static int answer = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    edgeList = new ArrayList[N];
    visited = new boolean[N];
    for(int i=0; i<N; i++) {
      edgeList[i] = new ArrayList<>();
    }
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      edgeList[a].add(b);
      edgeList[b].add(a);
    }
    for(int i=0; i<N; i++) {
      if(answer!=1)
        dfs(i,0);
    }
    System.out.println(answer);
  }
  public static void dfs(int start, int depth) {
    if(depth==4) {
      answer = 1;
      return;
    }
    visited[start]=true;
    for(int next : edgeList[start]) {
      if(!visited[next]) {
        dfs(next, depth+1);
      }
    }
    visited[start] = false;
  }
}
