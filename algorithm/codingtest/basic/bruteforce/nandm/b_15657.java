package algorithm.codingtest.basic.bruteforce.nandm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_15657 {
  static int N, M;
  static int[] arr;
  static int[] ans;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    ans = new int[N];
    arr = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      ans[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(ans);
    dfs(0, 0);
    System.out.println(sb);
  }

  public static void dfs(int at, int depth) {
    if(depth == M) {
      for(int i=0; i<M; i++) {
        sb.append(arr[i]).append(' ');
      }
      sb.append('\n');
      return;
    }
    for(int i=at; i<N; i++) {
      arr[depth] = ans[i];
      dfs(i, depth + 1);
    }
  }
}
