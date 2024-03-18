package algorithm.codingtest.basic.dp.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_9095 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int[] dp = new int[11];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for(int i=0; i<T; i++) {
      int n = Integer.parseInt(br.readLine());
      // Bottom-up 방식
      for(int j=3; j<=n; j++) {
        dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
      }
      System.out.println(dp[n]);
    }
  }
}
