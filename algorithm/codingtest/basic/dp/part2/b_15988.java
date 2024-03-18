package algorithm.codingtest.basic.dp.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_15988 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    long[] dp = new long[1_000_001];
    long mod = 1_000_000_009;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for(int i=4; i<=1_000_000; i++) {
      dp[i] = (dp[i-1]+dp[i-2]+dp[i-3]) % mod;
    }
    for(int i=0; i<T; i++) {
      int num = Integer.parseInt(br.readLine());
      System.out.println(dp[num] % mod);
    }
  }
}
