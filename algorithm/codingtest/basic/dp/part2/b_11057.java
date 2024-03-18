package algorithm.codingtest.basic.dp.part2;
// https://velog.io/@yoonuk/%EB%B0%B1%EC%A4%80-11057-%EC%98%A4%EB%A5%B4%EB%A7%89-%EC%88%98-Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_11057 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[][] dp = new long[N + 2][10];
    for(int i=0; i<10; i++) {
      dp[1][i] = 1;
    }
    for (int i = 2; i <= N+1; i++) {
      for (int j = 0; j < 10; j++) {
        for(int k=0; k<=j; k++) {
          dp[i][j] += dp[i-1][k] % 10_007;
        }
      }
    }
    System.out.println(dp[N+1][9] % 10_007);
  }
}
