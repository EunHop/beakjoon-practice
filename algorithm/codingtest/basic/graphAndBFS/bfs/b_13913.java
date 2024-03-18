package algorithm.codingtest.basic.graphAndBFS.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class b_13913 {
  static final int MAX_POSITION = 100_000;
  static int[] backTrace = new int[MAX_POSITION+1];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    // N==K 를 고려하지 않으면 틀린다. BFS(5,5)=2 나옴
    if(N==K) {
      System.out.println(0);
      System.out.println(N);
    } else {
      BFS(N, K);
      backTrace(N,K);
    }

  }

  public static void BFS(int N, int K) {
    Queue<Integer> queue = new LinkedList<>();
    int[] dist = new int[MAX_POSITION + 1];
    queue.offer(N);
    dist[N] = 0;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      if(cur==K) {
        System.out.println(dist[cur]);
      }
      for (int i : new int[]{cur + 1, cur - 1, cur * 2}) {
        if (i >= 0 && i <= MAX_POSITION && dist[i] == 0) {
          queue.offer(i);
          dist[i] = dist[cur] + 1;
          // 다음 위치에 현재 좌표를 저장한다.
          backTrace[i] = cur;
        }
      }
    }
  }
  public static void backTrace(int N, int K) {
    Stack<Integer> stack = new Stack<>();
    int cur = K;
    while (cur!=N) {
      stack.push(cur);
      cur = backTrace[cur];
    }
    stack.push(cur);
    while (!stack.isEmpty()) {
      System.out.print(stack.pop()+" ");
    }
  }
}
