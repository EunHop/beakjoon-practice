package algorithm.codingtest.basic.dp.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1699 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N+1];
    for(int i=1; i<=N; i++) {
      // 1^2로만 구성된 항의 개수로 초기화
      dp[i] = i;
      for(int j=1; j*j<=i; j++) {
        dp[i] = Math.min(dp[i], dp[i-j*j]+1);
      }
    }
    System.out.println(dp[N]);
  }
}
