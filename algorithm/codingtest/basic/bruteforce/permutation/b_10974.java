package algorithm.codingtest.basic.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_10974 {
  static int N;
  static boolean[] visit;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    visit = new boolean[N];
    arr = new int[N];
    dfs(0);
    System.out.println(sb);
  }
  public static void dfs(int depth) {
    if(depth == N) {
      for(int i=0; i<N; i++) {
        sb.append(arr[i]).append(' ');
      }
      sb.append('\n');
    }
    for(int i=0; i<N; i++) {
      if(!visit[i]) {
        visit[i] = true;
        arr[depth] = i+1;
        dfs(depth+1);
        visit[i] = false;
      }
    }
  }
}
