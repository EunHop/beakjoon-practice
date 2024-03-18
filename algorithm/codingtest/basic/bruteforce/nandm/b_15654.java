package algorithm.codingtest.basic.bruteforce.nandm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_15654 {
  static int N, M;
  static int[] arr;
  static int[] arr2;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[M];
    visited = new boolean[N];
    arr2 = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr2[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr2);
    dfs(0);
    System.out.println(sb);
  }
  public static void dfs(int depth) {
    if(depth == M) {
      for(int i=0; i<M; i++) {
        sb.append(arr[i]).append(' ');
      }
      sb.append('\n');
      return;
    }
    for(int i=0; i<N; i++) {
      if(!visited[i]) {
        visited[i] = true;
        arr[depth] = arr2[i];
        dfs(depth+1);
        visited[i] = false;
      }
    }
  }
}
