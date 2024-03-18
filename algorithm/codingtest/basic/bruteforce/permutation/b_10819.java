package algorithm.codingtest.basic.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_10819 {
  static int N, max = 0;
  static int[] arr, temp;
  static boolean[] visit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    temp = new int[N];
    visit = new boolean[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      temp[i] = Integer.parseInt(st.nextToken());
    }
    dfs(0);
    System.out.println(max);
  }
  public static void dfs(int depth) {
    if(depth == N) {
      int sum = 0;
      for(int i=0; i<N-1; i++) {
        sum += Math.abs(arr[i]-arr[i+1]);
      }
      max = Math.max(max, sum);
    }
    for(int i=0; i<N; i++) {
      if(!visit[i]) {
        visit[i] = true;
        arr[depth] = temp[i];
        dfs(depth+1);
        visit[i] = false;
      }
    }
  }
}
