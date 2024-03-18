package algorithm.codingtest.basic.dp.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_15990 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    // [숫자][끝나는 숫자]
    long[][] dp = new long[100_001][4];
    dp[1][1] = 1; // 1
    dp[2][2] = 1; // 2
    dp[3][1] = 1; // 2+1
    dp[3][2] = 1; // 1+2
    dp[3][3] = 1; // 3
    // 숫자를 받을 떄마다 매번 반복문으로 처리하는 것보다 반복문 한번으로 다 구해놓는게 더 빠르다.
    for(int j=4; j<=100_000; j++) {
      dp[j][1] = (dp[j-1][2]+dp[j-1][3]) % 1_000_000_009;
      dp[j][2] = (dp[j-2][1]+dp[j-2][3]) % 1_000_000_009;
      dp[j][3] = (dp[j-3][1]+dp[j-3][2]) % 1_000_000_009;
    }
    for(int i=0; i<T; i++) {
      int n = Integer.parseInt(br.readLine());
      sb.append((dp[n][1]+dp[n][2]+dp[n][3]) % 1_000_000_009).append('\n');
    }
    System.out.println(sb);
  }
}
