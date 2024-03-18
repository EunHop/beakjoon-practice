package algorithm.codingtest.basic.dp.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_2133 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    if(N%2 != 0) {
      System.out.println(0);
      return;
    }
    int[] dp = new int[N+1];
    dp[0] = 1;
    dp[2] = 3;
    for(int i=4; i<=N; i+=2) {
      dp[i] = dp[i-2]*dp[2];
      for(int j=4; j<=i; j+=2) {
        dp[i] += dp[i-j]*2;
      }
    }
    System.out.println(dp[N]);
  }
}
