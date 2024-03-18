package algorithm.codingtest.basic.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_14889 {
  static int n, result = Integer.MAX_VALUE;
  static int[][] S;
  static boolean[] visit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    S = new int[n][n];
    visit = new boolean[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        S[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dfs(0,0);
    System.out.println(result);
  }
  public static void dfs(int a, int depth) {
    if(depth == n/2) {
      diff();
      return;
    }
    for(int i=a; i<n; i++) {
      visit[i] = true;
      dfs(i + 1, depth + 1);
      visit[i] = false;
    }
  }
  public static void diff() {
    int start=0;
    int link=0;
    for(int i=0; i<n-1; i++) {
      for(int j=i+1; j<n; j++) {
        if(visit[i] && visit[j]) {
          start += S[i][j];
          start += S[j][i];
        }
        else if(!visit[i] && !visit[j]){
          link += S[i][j];
          link += S[j][i];
        }
      }
    }
    result = Math.min(result, Math.abs(start - link));
  }
}
