package algorithm.codingtest.basic.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_15661 {
  static int t, N, result = Integer.MAX_VALUE;
  static int[][] S;
  static boolean[] visit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    t = 0;
    S = new int[N][N];
    visit = new boolean[N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        S[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for(t=1; t<N; t++) {
      dfs(0,0);
    }
    System.out.println(result);
  }
  public static void dfs(int a, int depth) {
    if(depth == t) {
      diff();
      return;
    }
    for(int i=a; i<N; i++) {
      visit[i] = true;
      dfs(i+1, depth+1);
      visit[i] = false;
    }
  }

  public static void diff() {
    int link = 0;
    int start = 0;
    for(int i=0; i<N-1; i++) {
      for(int j=i+1; j<N; j++) {
        if(visit[i] && visit[j]) {
          link += S[i][j];
          link += S[j][i];
        }
        else if(!visit[i] && !visit[j]) {
          start += S[i][j];
          start += S[j][i];
        }
      }
    }
    result = Math.min(result, Math.abs(link-start));
  }
}
