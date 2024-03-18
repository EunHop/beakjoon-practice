package algorithm.codingtest.basic.graphAndBFS.queueAndGraph;

// 이분 그래프 https://loosie.tistory.com/227

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_1707 {
  static ArrayList<ArrayList<Integer>> edgeList;
  static int[] colors;
  // 색상 구분, 0은 안 칠한 상태
  static int V;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());
    for(int i=0; i<K; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      edgeList = new ArrayList<>();
      colors = new int[V+1];
      for(int j=0; j<=V; j++) {
        edgeList.add(new ArrayList<>());
      }
      for(int k=1; k<=E; k++) {
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        edgeList.get(from).add(to);
        edgeList.get(to).add(from);
      }
      boolean answer = false;
      for(int l=1; l<=V; l++) {
        if(colors[l] == 0)
          answer = bfs(l, 1);
        if(!answer)
          break;
      }
      if(answer) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
  public static boolean bfs(int start, int color) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    colors[start] = color;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for(int next : edgeList.get(cur)) {
        if(colors[next] == colors[cur]) {
          return false;
        }
        if(colors[next] == 0) {
          colors[next] = colors[cur] * -1;
          queue.offer(next);
        }
      }
    }
    return true;
  }
}
