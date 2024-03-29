package algorithm.codingtest.basic.dp.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_11052 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] P = new int[N+1];
    int[] D = new int[N+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; i++) {
    P[i] = Integer.parseInt(st.nextToken());
    }
    for(int i=1; i<=N; i++) {
      for(int j=1; j<=i; j++) {
        D[i] = Math.max(D[i], D[i-j]+P[j]);
      }
    }
    System.out.println(D[N]);
  }
}
