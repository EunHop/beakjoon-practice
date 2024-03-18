package algorithm.codingtest.basic.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_14501 {
  static int N, result = Integer.MIN_VALUE;
  static int[] T, P;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    T = new int[N];
    P = new int[N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }
    profit(0,0);
    System.out.println(result);
  }
  public static void profit(int idx, int sum) {
    if(idx >= N) {
      result = Math.max(result, sum);
      return;
    }
    if(idx+T[idx]<=N) {
      profit(idx + T[idx], sum + P[idx]);
    }
    profit(idx + 1, sum);
  }
}
