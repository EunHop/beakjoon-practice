package algorithm.codingtest.basic.graphAndBFS.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_1697 {
  static final int MAX_POSITION = 100_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    // N==K 를 고려하지 않으면 틀린다. BFS(5,5)=2 나옴
    if(N==K) {
      System.out.println(0);
    } else {
      BFS(N, K);
    }
  }

  public static void BFS(int N, int K) {
    Queue<Integer> queue = new LinkedList<>();
    int[] dist = new int[MAX_POSITION + 1];
    queue.offer(N);
    dist[N] = 1;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int i : new int[]{cur + 1, cur - 1, cur * 2}) {
        if (i == K) {
          System.out.println(dist[cur]);
          return;
        }
        if (i >= 0 && i <= MAX_POSITION && dist[i] == 0) {
          queue.offer(i);
          dist[i] = dist[cur] + 1;
        }
      }
    }
  }
}
