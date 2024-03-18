package algorithm.codingtest.basic.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_10971 {
  static int N, min = Integer.MAX_VALUE;
  static int[][] W;
  static int[] permutation;
  static boolean[] visit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    W = new int[N][N];
    permutation = new int[N];
    visit = new boolean[N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        W[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for(int k=0; k<N; k++) {
      visit[k] = true;
      permutation[0]= k;
      dfs(1,0,k);
      visit[k] = false;
    }
    System.out.println(min);
  }
  // permutation  : 현재 경우의 순열
  //visit : 방문한 도시 확인하는 배열
  //cost : 도시를 이동할 때 지불하는 비용
  public static void dfs(int depth, int cost, int start) {
    if(depth==N && W[permutation[depth-1]][start]!=0) {
      min = Math.min(min, cost+W[permutation[depth-1]][start]);
      return;
    }
    for(int i=0; i<N; i++) {
      if(!visit[i]) {
        visit[i] = true;
        permutation[depth] = i;
        if(W[permutation[depth-1]][permutation[depth]]!=0)
          dfs(depth+1, cost+W[permutation[depth-1]][permutation[depth]],start);
        visit[i] = false;
      }
    }
  }
}
